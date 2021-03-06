# 基于GridLayout的自定义日程信息控件ScheduleView
## 效果图
同时实现多种不同的子布局，支持自定义layout
![image](https://github.com/kirito0206/ScheduleViewDemo/blob/master/picture/test.jpg)
## 添加依赖库
Add it in your root build.gradle at the end of repositories:
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
}
```
Add the dependency:
```
dependencies {
    implementation 'com.github.kirito0206:ScheduleView:1.0.2'
}
```

## 使用方式
在XML文件中添加
```
<com.example.scheduleview.ScheduleView
        android:id="@+id/sv_main"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:rowCount="12"
        android:columnCount="8"/>
```
设置适配器类
```
/*
  可以传入数据类、横坐标Title、纵坐标Title的list
  数据类需要实现获取对应的x、y范围
*/
class SVAdapter(val context : Context,val list: ArrayList<T>) : ScheduleAdapter() {

    //返回日程表中的item数
    override fun getItemCount(): Int {
        return list.size
    }

    //获取item对应的横坐标
    override fun getDay(position: Int): Int {
        return list[position].day
    }

    //获取item对应的纵坐标范围
    override fun getBoundary(position: Int): Pair<Int, Int> {
        return Pair(list[position].timeX, list[position].timeY)
    }

    //设置item的布局样式，返回对应view
    override fun getView(position: Int): View {
    	//子布局只有单一控件，如TextView、EditView、ImageView等
	//可以像如下设置
        val textView = TextView(context)
        textView.text = position.toString()
        textView.gravity = Gravity.CENTER
        return textView
	//自己创建layout，如下进行初始化
	val inflater = LayoutInflater.from(context)
	var view =  inflater.inflate(R.layout.item_schedule, null)
	//view.textview.text = "内容"...
	view.foregroundGravity = Gravity.CENTER
	return  view
    }

    //设置横坐标Title
    override fun getXTitle(dayIndex: Int): String {
        return "XTitle"
    }

    //设置纵坐标Title
    override fun getYTitle(timeIndex: Int): String {
        return "YTitle"
    }

}
```
然后在代码中初始化view即可
```
	var adapter = SVAdapter(this,list)
	sv_main.adapter = adapter
	sv_main.post {
		sv_main.show()
	}
```
快去试试吧！！！好用的话可以点点Star
快乐码农
