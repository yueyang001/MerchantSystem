merchants-backend\nThis template provides a Spring Boot backend with PostgreSQL, Redis and Kafka (Docker).\n\nQuick start:\n1. Start Docker services:\n   docker compose up -d\n2. Build and run server:\n   mvn clean package -DskipTests\n   mvn spring-boot:run\n

安装的具体命令为：

在项目根目录执行CMD或者Powershell(这个成功概率更大一些)，输入：

```
docker compose up -d
```

docker自动下载这些镜像，如果下载不成功，绿色上网应该就ok了。

下载结束后，可以输入：

```
docker ps
```

检查镜像是否在运行。

---

在IntelliJ中打开之后，点开右侧Maven->reload all maven projects

---

找到```src/main/java/com/imooc/passbook/MerchantsApplication.java```这个文件，点击运行按钮就可以跑起来了。