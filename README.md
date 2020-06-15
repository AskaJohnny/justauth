# justauth

1.关于 JustAuth 的使用 

2.目前已经实现了 QQ 和 Github 的登录 

3.由于回调是地址是 在第三方开放平台上配置的 如QQ 这里 回调域： http://www.askajohnny.com/auth/qq   ，


本地测试:
1.配置host 映射  127.0.0.1 www.askajohnny.com
2.nginx 进行前端项目的配置 这里是Vue-cli创建的模板项目 
3.location /blogs 将第三方回调请求转发到本地 justauth 项目



    server {
        listen       80;
      
	      server_name www.askajohnny.com;
      
       location / {
	
	         proxy_http_version 1.1;
                 proxy_set_header Host $host;
                 proxy_set_header X-Real-IP $remote_addr;
                 proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
                 proxy_set_header Upgrade $http_upgrade;
                 proxy_set_header Connection "upgrade";
              
		 root /Users/johnny/FrontProject/VueProject/vue-justauth-learn/dist; #这里的地址需要你自己配置 vue-justauth-learn 项目地址
                 try_files $uri /index.html;
        }
	location /blogs{
                       proxy_http_version 1.1;
                       proxy_set_header Host $host;
                       proxy_set_header X-Real-IP $remote_addr;
                       proxy_set_header Upgrade $http_upgrade;
                       proxy_set_header Connection "upgrade";
		       proxy_pass http://localhost:8080/justauth;
         }


