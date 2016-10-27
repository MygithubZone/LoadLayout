# LoadLayout快速实现加载中界面,加载错误界面,空界面等功能

标签（空格分隔）： 未分类

---
当前版本1.1.0,修复布局中有fragment不能正常工作的bug
![示意图][1]
#1.使用方法
##1.引用
```
compile 'com.z:LoadLayout:1.1.0'
```
##2.布局中使用
```

    <com.z.loadlayoutlibrary.LoadLayout
        android:id="@+id/loadlayout"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:contentView="@+id/content"
        app:emptyView="@+id/empty"
        app:errorView="@+id/error"
        app:loadingView="@+id/loading">

        <LinearLayout
            android:id="@id/content"
            android:layout_width="match_parent"
            android:layout_height="match_parent">

            <TextView
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:text="这是主页面" />
        </LinearLayout>

        <include
            android:id="@id/empty"
            layout="@layout/empty_view"></include>

        <include
            android:id="@id/error"
            layout="@layout/error_view"></include>

        <include
            android:id="@id/loading"
            layout="@layout/loading_view"></include>
    </com.z.loadlayoutlibrary.LoadLayout>
```
##3.找到控件直接调用方法
```
mLoadlayoutLoadLayout = (LoadLayout) findViewById(R.id.loadlayout);
mLoadlayoutLoadLayout.showContent();//显示主界面
mLoadlayoutLoadLayout.showError();//显示错误界面
mLoadlayoutLoadLayout.showEmpty();//显示空界面
mLoadlayoutLoadLayout.showLoading();//显示加载中界面
```
#2.原理
继承自frameLayout,里面有四个子布局,通过控制其显隐来实现此功能
#3.注意
使用错误
```
<com.z.loadlayoutlibrary.LoadLayout
        android:id="@+id/loadlayout"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:contentView="@+id/content"
        app:emptyView="@+id/empty"//属性设置时一定要先用@+id,然后子布局中用@id
        app:errorView="@+id/error"
        app:loadingView="@+id/loading">
```
#4.应用范围
任何布局中都可以套用,不存在冲突等问题,主要用于需要网络加载的页面,可根据网络情况显示不同的界面


  [1]: https://github.com/zxyaust/LoadLayout/blob/master/2016-10-26_14_17_01.gif?raw=true