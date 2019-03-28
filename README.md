## Bamboy进度条Demo
  
进度条相信大家都很熟悉了，  
但是大部分情况下，  
都需要自定义一下，  
不然过不了设计那一关。  
  
如果想偷懒从网上找一个拿来用，  
奈何要么样式不对，  
要么颜色不对，  
要么就是可定制型太低。    
  
所以这次我为大家带来了这个Demo，  
完全用Canvas画出来，  
性能高，  
可定制型强，  
拒绝图片拼接，    
最重要的是，  
注释写的很全，  
逻辑很清晰，    
你懂得😏  
  
话不多说，  
看下效果吧，  
目前内置了三种进度条，  
而且会不定时更新，  
关注的话点个Star吧。

1、节点进度条：  
![节点进度条](https://img-blog.csdnimg.cn/20190328150154799.gif)
  
2、圆环进度条：  
![圆环进度条](https://img-blog.csdnimg.cn/20190328150145587.gif)
  
3、移动数字进度条：  
![移动数字进度条](https://img-blog.csdnimg.cn/20190328150137605.gif)
  
既然是自定义View，  
那么有自定义属性当然会如虎添翼了，  
那就来看一下自定义属性吧：  

公共属性：

| 属性           		| 含义					| 类型   |  
| ----------------- |-------------------| -----:|  
| progress    		| 默认进度				|   int |  
| progressMax  		| 最大进度       		|   int |  
| lineHeight   		| 进度条线条高度		|   int |  
| colorFinished  	| 已完成的进度条的颜色	| color |  
| colorUnfinished	| 未完成的进度条的颜色	| color |  
  
节点进度条独有属性：  

| 属性        | 含义		| 类型 |  
| ----------	|---------| ---:|  
| nounCount	| 节点数量 	| int |  
| nounHeight	| 节点高度	| int |  
  
圆环进度条独有属性：  

| 属性 				| 含义				| 类型 |  
| -------------	|--------------	| --------:|  
| lineWidth		| 线的宽度 			| int 	    |  
| color			| 圆圈的颜色		| color    |  
| imgType			| 内容类型 			| 枚举     |  
|					| not				| 没有图片  |  
|					| success			| 对号     |  
|					| error			| 叉号      |  
|					| progress		| 当前进度  |  
|					| picture			| 图片      |  
| pictureSrc		| 图片的资源路径	| reference|  
| pictureMargin	| 图片与圈的间距	| int      |  
  
移动数字进度条独有属性：  

| 属性        | 含义		| 类型 |  
| ----------	|---------| ---:|  
| textSize	| 数字大小 	| int |  
    
代码很简单，  
注释也很全，  
如果还是有疑问的地方，  
欢迎在文章下评论，  
或者加入QQ讨论群：569614530，  
群里找我，  
我是尘少。  
![扫码加入QQ讨论群](https://img-blog.csdnimg.cn/20190312095824708.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2JhbWJveV8=,size_16,color_FFFFFF,t_70)
  
本文github链接：  
https://github.com/Bamboy120315/BamProgressBar  
  
也可以先下载apk安装体验：  
![扫码下载apk](https://upload-images.jianshu.io/upload_images/6179866-063233038cb6ff90.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240) 
