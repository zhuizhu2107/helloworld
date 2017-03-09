## 开发环境：

- [JDK1.8+](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Eclipse Neon](https://www.eclipse.org/downloads/)
- [Maven-3.3.9](http://mirrors.tuna.tsinghua.edu.cn/apache/maven/maven-3/3.3.9/binaries/apache-maven-3.3.9-bin.zip)

## 安装：

- [JDK1.8+](https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html)
- [Eclipse Neon](https://wiki.eclipse.org/Eclipse/Installation)
- [Maven-3.3.9](http://maven.apache.org/install.html)

## 相关配置

1. 打开Eclipse，设置编码格式```UTF-8```

> Window->Preferences->General->Workspace->Text file encoding->UTF-8

![utf-8](http://images2015.cnblogs.com/blog/683206/201611/683206-20161108202851202-545799027.png)

2. 在Eclipse中打开：

> Window->Show View->Other...->找到Git Repositories并双击

> Window->Show View->Other...->找到Git Staging并双击

![git_config](http://images2015.cnblogs.com/blog/683206/201611/683206-20161108203411967-1216862061.png)

3. 配置Maven到Eclipse中

> Window->Preferences->Maven->Installations->Add...->选择前面安装的Maven的目录
![maven_home](http://images2015.cnblogs.com/blog/683206/201611/683206-20161108211508764-2104490465.png)

点击Finish。

## 导入仓库
1. 在```Git Repositories```下点击```clone git repository```

![clone_repo](http://images2015.cnblogs.com/blog/683206/201611/683206-20161108203637702-1899128894.png)


2. 输入URI以及Github用户名和密码

![config_git](http://images2015.cnblogs.com/blog/683206/201611/683206-20161108203844030-1971557385.png)

![master](http://images2015.cnblogs.com/blog/683206/201611/683206-20161108203947420-1895367231.png)

![master2](http://images2015.cnblogs.com/blog/683206/201611/683206-20161108204023842-192295314.png)

3. 点击finsh

![finish_checkout](http://images2015.cnblogs.com/blog/683206/201611/683206-20161108204122155-1525882492.png)



## 导出项目
1. 在控制台下，我们进入源码的目录执行：

```mvn eclipse:eclipse```

![maven_eclipse_eclipse](http://images2015.cnblogs.com/blog/683206/201611/683206-20161108211951452-578952279.png)

![maven_eclipse_eclipse2](http://images2015.cnblogs.com/blog/683206/201611/683206-20161108212132499-1018055935.png)

2. 在```src```目录下右键，选择```Import Projects```：

![export_project](http://images2015.cnblogs.com/blog/683206/201611/683206-20161108204511780-558545848.png)

3. 选择```import exsiting Eclipse Projects```:

![importeep](http://images2015.cnblogs.com/blog/683206/201611/683206-20161108212320530-795871568.png)

![next_ei](http://images2015.cnblogs.com/blog/683206/201611/683206-20161108212448311-1665389979.png)

4. 项目导入完成

![import_f](http://images2015.cnblogs.com/blog/683206/201611/683206-20161108212813545-1450346258.png)


## 运行项目

> 选择App.java
> 右键-> Run As->Java Application

![runrun](http://images2015.cnblogs.com/blog/683206/201611/683206-20161108212954217-1821376908.png)