# Spring-coffee
web site with spring technology


1	create web-app and quick
2	create project on github
3	create user interface
4	"add dependoncies (javaee api, aven-compiler-plugin + ""<build>
  <plugins>
   <plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-compiler-plugin</artifactId>
    <version>${maven-compiler-plugin.version}</version>
    <configuration>
     <source>${java.version}</source>
     <target>${java.version}</target>
    </configuration>
   </plugin>
  </plugins>
 </build>"""
5	web.xml mkyong
6	spring dependencies (spring mvc)
7	"configure the FrontController (web.xml) <servlet>
  <servlet-name>dispatcher</servlet-name>
  <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
 </servlet>
 <servlet-mapping>
  <servlet-name>dispatcher</servlet-name>
  <url-pattern>/</url-pattern>
 </servlet-mapping>"
8	create java folder in web-project
9	create PageController 
10	create view folder in WEB-INF/views
11	"create spring configuration file (spring bean configuration xml file) name = dispatcher-servlet.xml
<?xml version=""1.0"" encoding=""UTF-8""?>
<beans xmlns=""http://www.springframework.org/schema/beans""
 xmlns:xsi=""http://www.w3.org/2001/XMLSchema-instance"" xmlns:context=""http://www.springframework.org/schema/context""
 xsi:schemaLocation=""http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
  http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.3.xsd"">
<context:component-scan base-package=""com.denis.coffee.controller""/>
<bean id=""viewResolver""
  class=""org.springframework.web.servlet.view.InternalResourceViewResolver"">
  <property name=""prefix"" value=""/WEB-INF/views/""/>
  <property name=""suffix"" value="".jsp""/>
  </bean>
</beans>"
12	add JSTL dependency
13	add row to jsp (<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>)
14	all css, fonts, js, images must be saved in webapp/assets
15	unstyled starter templates bootstrap
16	add mvcnamespace in dispatcher-servlet.xml
17	"loading static resurses
<mvc:annotation-driven/>
<mvc:resources location=""/assets/"" mapping=""/resources/**""/>"
18	"add the spring url tag library to jsp
<%@taglib prefix=""spring"" uri=""http://www.springframework.org/tags"" %>"
19	creating master page
20	separate page (footer, navigation ….)
21	script for shine menu
$(function(){
	switch(menu) {
	
	case 'About':
		$('#about').addClass('active');
		break;
	case 'Contacts':
		$('#contacts').addClass('active');
		break;
	case 'Services':
		$('#services').addClass('active');
		break;
	default:
		$('#home').addClass('active');
		break;
	}
});

22	css style

html {
	height: 100%;
}

body {
	padding-top: 54px;
	height: 100%;
}

@media ( min-width : 992px) {
	body {
		padding-top: 56px;
	}
}

footer {
	margin: 0;
}

.wrapper {
	min-height: 100%;
	position: relative;
}

.content {
	padding: 60px;
}

.footer {
	width: 100%;
	position: absolute;
	bottom: 20px;
	height: 60px;
}
23	
24	
25	https://github.com/levi-putna/Hibernate-H2-Example/blob/master/hibernate-h2-example/src/hibernate.cfg.xml
