# TakeWebNews
------------------------
获取中州大学的通知与新闻摘要或内容,

！[](spider.jpg)
这是一个用jsoup作为工具去做的一个spider，获取中州大学的所有的通告信息和新闻（包含正文）  

结构很简单：利用URL获取html源码，然后分析网页。
在文章列表里，文章的链接在一个类为c67738的a标签的href属性里面，通过jsoup selector选择器将其获取到即可，如果当前页面有下一页，那么这个下一页的链接地址在一个类为Next的a标签的href属性里，同理，利用Slecetor获取即可，然后利用地址作为参数递归调用，可以不断处理完本页然后进入下一页，直至最后一页，然后结束堆栈。
对于页内文章来说，title在一个类为titlestyle67448的td标签里面，date在一个类为timestyle67448的span标签里面，article在一个id为vsb_newscontent的div里面。  
！[](pic1.png)

程序正在辛苦的跑着，>.<  

！[](pic2.png)
！[](pic3.png)
