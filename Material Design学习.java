Activity 和 Fragment 切换
通过声明两屏之间通用的共享元素，你可以在两种状态间创建流畅的切换。
一图胜千言：



album_grid.xml
…
    <ImageView
        …
        android:transitionName="@string/transition_album_cover" />
album_details.xml
…
    <ImageView
        …
        android:transitionName="@string/transition_album_cover" />

AlbumActivity.java
Intent intent = new Intent();
String transitionName = getString(R.string.transition_album_cover);
…
ActivityOptionsCompat options =
ActivityOptionsCompat.makeSceneTransitionAnimation(activity,
    albumCoverImageView,   // The view which starts the transition
    transitionName    // The transitionName of the view we’re transitioning to
    );
ActivityCompat.startActivity(activity, intent, options.toBundle());

1.目标启动包含共同元素的Activity 2.准备要启动的Activity的那个View3.共同元素transitionName

我们在两屏之间定义了相同的transitionName。当打开新的Activity的时候，切换过程就自动开始了。
除了共享元素之外，你也可以定义进入和退出元素。

CoordinatorLayout 
coordinatorLayout是为了让子View协调工作的布局


CoordinatorLayout
组织它的子views之间协作的一个Layout，它可以给子View切换提供动画效果。
AppBarLayout
可以让包含在其中的控件响应被标记了ScrollingViewBehavior的View的滚动事件
CollapsingToolbarLayout
可以控制包含在CollapsingToolbarLayout其中的控件，在响应collapse时是移除屏幕和固定在最上面
TabLayout
结合ViewPager，实现多个TAB的切换的功能
NestedScrollView
与ScrollView基本相同，不过包含在NestedScrollView中的控件移动时才能时AppBarLayout缩放

<android.support.v7.widget.CardView>包含其他布局就能实现卡片效果
app:cardBackgroundColor 设置CardView背景颜色
app:cardCornerRadius 设置CardView圆角大小
app:cardElevation 设置CardView阴影高度