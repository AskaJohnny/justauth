# justauth

1.关于 JustAuth 的使用 

2.目前已经实现了 QQ 和 Github 的登录 

3.由于回调是地址是 在第三方开放平台上配置的 如QQ 这里 回调域： http://www.askajohnny.com/auth/qq   ，

4.如果要在本地测试 需要一个 nginx 对其域名 www.askajohnny.com 进行转发到 本地 该项目的地址 


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
              
		             root /Users/johnny/FrontProject/VueProject/blogs2/dist;
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

