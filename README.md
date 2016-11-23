HVScrollView
==================  

#导入方式#
  gradle导入      

    compile 'com.shizhefei:HVScrollView:1.0.0'  
    compile 'com.android.support:support-v4:23.4.0'  
# 效果图 # 
![image](https://github.com/LuckyJayce/HVScrollView/blob/master/raw/HVScrollView.gif)

# 使用方法 # 

    <!-- app:scrollOrientation="both" 可以滚动的方向，默认双向滚动,可以配置both,vertical,horizontal,none 四个值-->
    <!--childLayoutCenter 内容是否居中显示，默认false右上角对齐-->
    <!--fillViewportV  垂直内容宽度是否充满，默认false自适应-->
    <!--fillViewportV  水平内容高度是否充满，默认false自适应-->

    <!--android:scrollbars="horizontal|vertical" 显示滚动条-->
    <!--android:fadingEdge="horizontal|vertical" 显示滚动条-->

    <com.shizhefei.view.hvscrollview.HVScrollView xmlns:app="http://schemas.android.com/apk/res-auto"
        android:id="@+id/guide_hvScrollView"
        android:layout_width="match_parent"
        android:layout_height="500dp"
        android:fadingEdge="horizontal|vertical"
        android:scrollbars="horizontal|vertical"
        app:childLayoutCenter="false"
        app:fillViewportH="false"
        app:fillViewportV="false"
        app:scrollOrientation="both">

        <TextView
            android:layout_width="1000dp"
            android:layout_height="1000dp"
            android:layout_margin="8dp"
            android:text="Hello World"
            android:textColor="#fff" />

    </com.shizhefei.view.hvscrollview.HVScrollView>

HVScrollView 配置 app:scrollOrientation="horizontal"  相当于 HorizontalScrollView  
HVScrollView 配置 app:scrollOrientation="vertical"  相当于 NestedScrollView 或者，ScrollView  
HVScrollView 配置 app:scrollOrientation="both" 双向滚动  
HVScrollView 配置 app:scrollOrientation="none" 不能滚动  
代码通过setScrollOrientation 设置滚动方向

##为什么写这个类库##

1.解决ScrollView嵌套ScrollView，当然NestedScrollView也可以，但是它没有水平方向的  
2.解决HorizontalScrollView 在ViewPager下滑动，滑动到末尾切换不了下一个页面ViewPager  
3.支持双向滚动和配置滚动方向  
4.支持CoordinatorLayout和实现NestedScrollingParent,NestedScrollingChild的配合滑动，当然NestedScrollView也是可以.但是它没有水平方向的  

##主力类库##

**1.https://github.com/LuckyJayce/ViewPagerIndicator**  
Indicator 取代 tabhost，实现网易顶部tab，新浪微博主页底部tab，引导页，无限轮播banner等效果，高度自定义tab和特效

**2.https://github.com/LuckyJayce/MVCHelper**  
实现下拉刷新，滚动底部自动加载更多，分页加载，自动切换显示网络失败布局，暂无数据布局，支持任意view，支持切换主流下拉刷新框架。

**3.https://github.com/LuckyJayce/MultiTypeView**  
简化RecyclerView的多种type的adapter，Fragment可以动态添加到RecyclerView上，实现复杂的界面分多个模块开发

**4.https://github.com/LuckyJayce/EventBus**  
事件总线，通过动态代理接口的形式发布,接收事件。定义一个接口把事件发给注册并实现接口的类

**5.https://github.com/LuckyJayce/LargeImage**  
大图加载，可供学习

**6.https://github.com/LuckyJayce/GuideHelper**    
新手引导页，轻松的实现对应的view上面的显示提示信息和展示功能给用户  

**7.https://github.com/LuckyJayce/HVScrollView**    
可以双向滚动的ScrollView，支持嵌套ScrollView联级滑动，参照NestedScrollView和RecyclerView代码写的

有什么建议可以发到我的邮箱  794629068@qq.com  

# 联系方式和问题建议

* 微博:http://weibo.com/u/3181073384
* QQ 群: 开源项目使用交流，问题解答: 549284336（开源盛世） 

License
=======

    Copyright 2016 shizhefei（LuckyJayce）

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
