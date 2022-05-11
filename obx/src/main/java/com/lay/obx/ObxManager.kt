package com.lay.obx

@PublishedApi
internal class ObxManager private constructor(){
    private val listenerMap = HashMap<Long, ArrayList<OnDataChangeListener<out Any>>>()
    private val obxMap = HashMap<Int, HashMap<String, Obx<out Any>>>()
    private val needSubscribeObxMap = HashMap<Int, ArrayList<Pair<String, (Obx<out Any>) -> Unit>>>()

    companion object{
        val instance = ObxManager()
    }

    fun addObxWithLifecycleOwner(hashCode : Int, obx : Obx<out Any>) : Boolean{
        var obxSubMap = obxMap[hashCode]
        if(obxSubMap == null){
            obxSubMap = HashMap()
            obxMap[hashCode] = obxSubMap
        }
        return if(obxSubMap.containsKey(obx.key)){
            false
        } else {
            obxSubMap[obx.key] = obx
            needSubscribeObxMap[hashCode]?.let {
                val iterator = it.iterator()
                var item : Pair<String, (Obx<out Any>) -> Unit>
                while(iterator.hasNext()){
                    item = iterator.next()
                    if(item.first == obx.key){
                        item.second.invoke(obx)
                        iterator.remove()
                    }
                }
            }
            true
        }
    }

    fun removeObx(hashCode : Int, key : String) : Boolean{
        obxMap[hashCode]?.let {
            return if(it.containsKey(key)){
                it.remove(key)
                if(it.isEmpty()){
                    obxMap.remove(hashCode)
                }
                true
            } else {
                false
            }
        }
        return false
    }

    fun removeObxWithLifecycleOwner(hashCode : Int){
        val obxSubMap = obxMap[hashCode]
        obxSubMap?.let{
            it.forEach {
                listenerMap.remove(it.value.code)
            }
            obxMap.remove(hashCode)
        }
    }

    fun <T : Any> findWithLifecycleOwner(hashCode : Int, key : String) : Obx<T>? {
        val obxList = obxMap[hashCode]
        obxList?.let{
            obxList[key]?.let {
                return it as Obx<T>
            }
        }
        return null
    }

    fun <T : Any> findWithLifecycleOwner(hashCode : Int, key : String, block: ((Obx<T>) -> Unit)){
        val obxList = obxMap[hashCode]
        if(obxList != null && obxList[key] != null){
            block(obxList[key] as Obx<T>)
        } else {
            var list = needSubscribeObxMap[hashCode]
            if(list == null){
                list =  ArrayList()
                needSubscribeObxMap[hashCode] = list
            }
            list.add(key to block as (Obx<out Any>) -> Unit)
        }
    }

    fun <T : Any> subscribe(obx : Obx<T>, listener: OnDataChangeListener<T>){
        var listenerList = listenerMap[obx.code]
        if(listenerList == null){
            listenerList = ArrayList()
            listenerMap[obx.code] = listenerList
        }
        listenerList.add(listener)
    }

    fun <T : Any> update(obx: Obx<T>){
        var listenerList = listenerMap[obx.code]
        listenerList?.let {
            it.forEach {
                (it as OnDataChangeListener<T>).update(obx)
            }
        }
    }
}