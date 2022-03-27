package com.lay.obx

@PublishedApi
internal class ObxManager private constructor(){
    private val listenerMap = HashMap<Long, ArrayList<OnDataChangeListener<out Any>>>()
    private val obxMap = HashMap<Int, HashMap<String, Obx<out Any>>>()

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
            true
        }
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