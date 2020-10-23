# WebSample
1.於tomcat/server.xml下增加一行  

    <Context path="/report" docBase="本地端路徑" />

 path可自定義名稱，docBase為本機端路徑，可自行修改。
 
2.於tomcat/web.xml將listings預設值false改為true

    <init-param>
        <param-name>listings</param-name>
        <param-value>true</param-value>
    </init-param>
        
3.於webapp/WEB-INF下建立lib資料夾並將下列jar檔案放到裡面
  >fonts.jar
