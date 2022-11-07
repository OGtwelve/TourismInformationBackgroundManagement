-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: travel_website
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `account_id` int NOT NULL AUTO_INCREMENT,
  `account_phone` varchar(11) DEFAULT NULL,
  `account_email` varchar(20) DEFAULT NULL,
  `account_id_card` varchar(18) DEFAULT NULL,
  `account_age` varchar(2) DEFAULT NULL,
  `account_gender` varchar(1) DEFAULT NULL,
  `account_balance` decimal(9,0) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`account_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `account_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'18736262111','2200434404@qq.com','52242419831207501338','22','男',999999,1),(2,'18736262112','1245489602@qq.com','52242419831207501338','20','男',1230,2),(5,'18736262113','1245489603@qq.com','52242419831207501338','0','男',0,5),(6,'18736262114','1245489601@qq.com','52242419831207501338','19','男',7999,6),(8,'18736262115','1245489604@qq.com','','0','男',0,8),(9,'13700815951','67723078@qq.com','52242419831207501338','0','男',1963,9),(10,'13683848111','ogtwelve@foxmail.com',NULL,'0','男',0,10);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attraction`
--

DROP TABLE IF EXISTS `attraction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attraction` (
  `attraction_id` int NOT NULL AUTO_INCREMENT,
  `attraction_name` varchar(30) DEFAULT NULL,
  `attraction_position` varchar(600) DEFAULT NULL,
  `attraction_information` varchar(500) DEFAULT NULL,
  `opening_time_up` time DEFAULT NULL,
  `opening_time_off` time DEFAULT NULL,
  `attraction_project` decimal(9,0) DEFAULT NULL,
  `tour_id` int DEFAULT NULL,
  PRIMARY KEY (`attraction_id`),
  KEY `tour_id` (`tour_id`),
  CONSTRAINT `attraction_ibfk_1` FOREIGN KEY (`tour_id`) REFERENCES `tour` (`tour_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attraction`
--

LOCK TABLES `attraction` WRITE;
/*!40000 ALTER TABLE `attraction` DISABLE KEYS */;
INSERT INTO `attraction` VALUES (1,'厦门鼓浪屿','https://map.baidu.com/search/%E5%8E%A6%E9%97%A8%E9%BC%93%E6%B5%AA%E5%B1%BF/@13143579.911657145,2790595.54299,16.65z?querytype=s&da_src=shareurl&wd=%E5%8E%A6%E9%97%A8%E9%BC%93%E6%B5%AA%E5%B1%BF&c=300&src=0&pn=0&sug=0&l=13&b=(13238916,2977463;13300356,3007447)&from=webmap&biz_forward=%7B%22scaler%22:1,%22styles%22:%22pl%22%7D&device_ratio=1','鼓浪屿是个宁静美丽的小岛，这里有着各种风格迥异、中西合壁的建筑，汇集了各种特色的食铺和商铺，充满了文艺范儿。2017年7月8日，在波兰克拉科夫举行的第41届世界遗产大会上，鼓浪屿申遗成功，成为中国第52项世界遗产。第一次上岛的游客，建议购买鼓浪屿联票，可以把岛上主要景点一次玩个遍。你可以顺着套票上的景点一个个往下走，套票包括的景点有：可以俯视全岛的日光岩、堪称江南古典园林精品的菽庄花园（含钢琴博物馆）、明代风格建筑的皓月园（内有郑成功石像）、风琴博物馆和国际刻字艺术馆等。除外，鼓浪屿上还有闽南建筑风格的海天堂构及中完合壁的八卦楼，以及19世纪欧陆风格的原西方国家领事馆，正因为其多种建筑风格，所以鼓浪屿又有万国建筑博览之称。玩鼓浪屿，可以住厦门，坐船过来一日游，5小时左右就可以玩遍全岛了。但是要真正体会鼓浪屿的精髓，建议至少在岛上住上一晚，不那么匆促。你可以享受一下傍晚的鼓浪屿，没有那么多的游客，你的心情可以很平静，你还可以在日落的时候漫步在鼓浪屿的沙滩上，就这样安安静静的走一走。','08:00:00','17:00:00',0,1),(2,'布达拉宫','https://map.baidu.com/search/%E5%B8%83%E8%BE%BE%E6%8B%89%E5%AE%AB/@10143929.994943261,3438669.95818,18.53z?querytype=s&da_src=shareurl&wd=%E5%B8%83%E8%BE%BE%E6%8B%89%E5%AE%AB&c=300&src=0&pn=0&sug=0&l=13&b=(13238905,2977516;13300345,3007500)&from=webmap&biz_forward=%7B%22scaler%22:1,%22styles%22:%22pl%22%7D&device_ratio=1',' 布达拉宫 坐落在中华人民共和国西藏自治区首府拉萨市区西北的玛布日山上，是一座规模宏大的宫堡式建筑群，最初是吐蕃王朝赞普松赞干布兴建。于17世纪重建后，成为历代达赖喇嘛的冬宫居所，为西藏政教合一的统治中心。整座宫殿具有鲜明的藏族风格，依山而建，气势雄伟。宫中收藏了无数的珍宝，为一座艺术殿堂。','09:30:00','15:00:00',200,2),(3,'丽江古城','https://map.baidu.com/search/%E4%B8%BD%E6%B1%9F%E5%8F%A4%E5%9F%8E/@11158645.121773083,3088625.329125,16.94z?querytype=s&da_src=shareurl&wd=%E4%B8%BD%E6%B1%9F%E5%8F%A4%E5%9F%8E&c=100&src=0&pn=0&sug=0&l=18&b=(10143267.137584122,3438346.4699792117;10144592.8523024,3438993.4463807885)&from=webmap&biz_forward=%7B%22scaler%22:1,%22styles%22:%22pl%22%7D&device_ratio=1','丽江地处金沙江上游，历史悠久，风光秀美，自然环境雄伟，是古代羌人的后裔、纳西族的故乡。丽江古城海拔2，400米，是丽江纳西族自治县的中心城市，是中国历史文化名城之一，是国家重点风景名胜区。','08:30:00','17:00:00',50,3),(4,'杭州西湖','https://map.baidu.com/search/%E8%A5%BF%E6%B9%96%E9%A3%8E%E6%99%AF%E5%8C%BA/@13370075.499704001,3511314.722945,14.12z?querytype=s&da_src=shareurl&wd=%E6%9D%AD%E5%B7%9E%E8%A5%BF%E6%B9%96&c=114&src=0&pn=0&sug=0&l=16&b=(11156640.996216094,3087647.2741005737;11160649.247330071,3089603.3841494266)&from=webmap&biz_forward=%7B%22scaler%22:1,%22styles%22:%22pl%22%7D&device_ratio=1','西湖美景甲天下，位于浙江杭州的西湖可谓的有名的风景区，总面积超过49平方千米，需要浏览几天都看不完，\"雷峰塔\"\"断桥\"\"钱王祠\"\"云隐寺\"等众多景点，也被列为世界遗产名录。','08:00:00','17:00:00',100,4),(5,'泰山','https://map.baidu.com/search/%E6%B3%B0%E5%B1%B1/@13031128.219459152,4313733.267085,13.48z?querytype=s&da_src=shareurl&wd=%E6%B3%B0%E5%B1%B1&c=179&src=0&pn=0&sug=0&l=14&b=(13355944.230255973,3504418.369052915;13384206.76915203,3518211.076837085)&from=webmap&biz_forward=%7B%22scaler%22:1,%22styles%22:%22pl%22%7D&device_ratio=1','\"五岳归来不看山，泰山归来不看岳\"，\"五岳之首的泰山是世界自然和文化双重遗产，最高峰达1545米，气势磅礴，一览众山小。同时也是古代帝王祭祀地点，正所谓：\"泰山安则国泰民安\"，泰山的气势会玩让人一生难忘。','00:00:00','00:00:00',115,5),(6,'三亚','https://map.baidu.com/search/%E4%B8%89%E4%BA%9A%E5%B8%82/@12191683,2054348.88,12z?querytype=s&da_src=shareurl&wd=%E4%B8%89%E4%BA%9A&c=325&src=0&pn=0&sug=0&l=13&b=(13010766.425702369,4302551.612047493;13051869.00076651,4322610.524982441)&from=webmap&biz_forward=%7B%22scaler%22:1,%22styles%22:%22pl%22%7D&device_ratio=1','海南三亚是一座国际旅游城市，也被称为\"东方夏威夷\"，聚集着众多的少数民族，属热带海洋性季风气候，温度比较舒适，每年都接待来自世界各地的众多游客，众多的旅游风景区都拥有着独特的风光景色。','00:00:00','00:00:00',0,6),(7,'湘西凤凰古城','https://map.baidu.com/search/%E5%87%A4%E5%87%B0%E5%8F%A4%E5%9F%8E/@12201693.56463252,3223198.22792,16.82z?querytype=s&da_src=shareurl&wd=%E5%87%A4%E5%87%B0%E5%8F%A4%E5%9F%8E&c=300&src=0&pn=0&sug=0&l=13&b=(13238949,2977401;13300389,3007385)&from=webmap&biz_forward=%7B%22scaler%22:1,%22styles%22:%22pl%22%7D&device_ratio=1','凤凰古城被称为湘西明珠，中国最美的古城，国家AAAA级风景名胜 区，位于湖南省湘西土家族苗族自治州凤凰县，与湖南省怀化地区麻阳县，贵州省铜仁地区松桃县，重庆市秀山县交界。2003年以来，凤凰古城逐渐成为备受游客热捧的国内旅游目的地。','00:00:00','00:00:00',0,6);
/*!40000 ALTER TABLE `attraction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attraction_project`
--

DROP TABLE IF EXISTS `attraction_project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attraction_project` (
  `attraction_project_id` int NOT NULL AUTO_INCREMENT,
  `attraction_items` varchar(20) DEFAULT NULL,
  `attraction_project_information` varchar(550) DEFAULT NULL,
  `attraction_project_price` decimal(9,0) DEFAULT NULL,
  `attraction_id` int DEFAULT NULL,
  PRIMARY KEY (`attraction_project_id`),
  KEY `attraction_id` (`attraction_id`),
  CONSTRAINT `attraction_project_ibfk_1` FOREIGN KEY (`attraction_id`) REFERENCES `attraction` (`attraction_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attraction_project`
--

LOCK TABLES `attraction_project` WRITE;
/*!40000 ALTER TABLE `attraction_project` DISABLE KEYS */;
INSERT INTO `attraction_project` VALUES (1,'日光岩','日光岩是鼓浪屿的龙头景点，包括日光岩和琴园两部分。顶峰一直径40多米的巨石凌空耸立，成为厦门的象征。zhenchenggong曾留下许多动人的传说。景区奇石叠磊，洞壑天成，海浪拍岸，树海叠嶂，繁花如星，富有亚热带浪漫迷情。拥有一片瓦、\"鹭江龙窟\"、\"古避暑洞\"、\"龙头山寨\"、\"水操台\"、\"百米高台\"等胜景。攀天梯，阅名人章句，一览众山小。琴园通过缆车与其相连，有现代游乐项目 \"百鸟园\"、\"电影院\"、\"英雄园\"等，并于1999年成为全国首家通过ISO14001标准的国家级风景名胜区。',60,1),(2,'厦门博物馆','厦门博物馆站在厦门市区内任何一个居高的地方。一眼望去，就可见到鼓浪屿有两个突出的标志：屹立鹭江第一峰的日光岩和雄视厦鼓海峡的八卦楼，八卦楼的原主人林鹤寿，是菽庄花园原主人林尔嘉的堂兄弟，始建于一九零七年，现己作为厦门博物馆。因该楼圆圆的红顶楼盖独具特色，有八卦形状，便被人们称为八卦楼。这座百年古楼当可与欧洲百年古堡相媲美。',20,1),(3,'皓月园','皓月园位于鼓浪屿东部的覆鼎岩海滨，始建于1985年，园以延平二王集中\"思君寝不寐，皓月透素帏\"诗句取名\"皓月园\"。占地3万平方米，沿鹭江之滨铺开，亭台楼阁，飞檐巧梁，与亚热带植被形成了柳暗花明又一村的障景。活脱脱一个大观园。园内长13.7米、高4.7米、耗铜18吨郑成功及其部将巨型铜雕像让我们也有站在巨人肩膀上的冲动。',30,1),(4,'菽庄花园','菽庄花园位于鼓浪屿东南海滨，建于一九一三年。原为台湾富商linerjia私人花园。菽庄花园背倚晃岩，面临大海，东邻观海园，西眺港仔后。全园分为藏海园、补山园两大部分，各造五景：眉寿堂、壬秋阁、真率亭、四十四桥、招凉亭；补山五景为顽石山房、十二洞天, 亦爱吾庐、听潮楼、小兰亭。菽庄十景各具风色，如果说西湖十景是十位婉约的美人，菽庄十景可比十位奔放而又不失清秀的佳丽。',30,1),(5,'海底世界','海底世界轮渡上岸后右转不远，可以看见一个巨型章鱼的铜雕，那就是海底世界的入口。不过好像全国的海底世界都差不多，这里有一具从厦门海域捕获的世界最大的抹香鲸的标本，可以让对海洋感兴趣的朋友过过瘾！',90,1),(6,'雪城','雪意为下方，专指山上城堡之下正面的村镇。雪城系指布达拉宫山下正面所有建筑的总称。雪城是布达拉宫总体建筑群的重要组成部分，它的历史与布达拉宫一样久远。\r\n    雪城规模为东西长317米，南北宽170米。占地面积5万平方米。2002年至2006年，国家投巨资对现存22处建筑物进行了维修保护，总面积33470平方米。从其历史上的建筑及附属功能看，主要包括三大类。一类是原西藏地方政府的办公用房及其附属建筑；二类是僧俗贵族及官员的宅院；三类是一些低等职员、工匠、农奴的住所，以及相应的服务性设施等。\r\n    从原有建筑的使用功能和保护利用的价值出发，目前以原状式陈列、复原式陈列、动态展示和专题展览等形式对公众大部分开放，同时设布达拉宫珍宝馆和游客服务中心。\r\n',50,2),(7,'珍宝馆','布达拉宫珍宝馆位于布达拉宫山脚下的雪城中，原名\"斋康\"，是座具有浓厚藏民族特色的土石木结构的三层建筑，早期一楼和二楼为布达拉宫库房，三楼为贵族官员的住宅，在保留其原样的基础上进行外部整修和内部装修后，现改造成布达拉宫珍宝馆，建筑面积2000多平方米。\r\n    珍宝馆占地面积为2500m2，建筑面积为2199 m2，外观是典型的藏式建筑风格，内部设计是一座现代化的博物馆，展览文字及实物说明一律采用了藏汉英三种文字。展板、展柜的造型色彩均融入藏文化元素，与周围古建筑环境、民俗环境相协调，彰显古雅、精致。展示手法主要为文字、实物等形式。前后历时九年，总投资1900多万元，安装监控设备等耗资1600万元，到2009年珍宝馆修建完毕，5月8日，开始交接文物并布展。\r\n    2009年8月11日，珍宝馆正式对外开放。整个展览分为三层楼，两个大部分，共展示各类文物及文物复制品273单件，155套件（或159套件，其中珍品147套件，复制品6件，壁画6幅。）。根据布展要求，共设有22个通柜，34个独立柜，3个吊柜。内容涵盖西藏的历史，文化，艺术等各方面，拥有200多件绝世珍品的布达拉宫珍宝馆正式向世人敞开怀抱，成为了人们了解和认识西藏历史文化的一扇窗口，并将成为雪域高原又一处令人心驰神往的密境\r',50,2),(8,'松格果觉--白宫门庭','此处是布达拉宫正面的入口处。经德央夏（东庭院）登十二层石阶至木制三排梯（中间梯道专供达赖喇嘛上下）便可到达门庭内。门庭呈四方形，内设四柱八梁，柱间雕有莲花、八药师像等造型，雀堤中央雕制虎、狮、鹏、龙四兽。周围墙壁绘有极精美的壁画。其中，东壁绘有从律经引用的僧人生活用具的样品；南壁绘有五世达赖喇嘛致全藏文告及本人双掌印。西壁绘有四大天王像；北壁绘有吐蕃松赞干布时期（公元七世纪）布达拉宫正面全景图以及文成公主进藏图，大昭寺奠基开工和阿底夏尊者（十一世纪印度著名佛学大师）入藏宏法图等；东壁（白宫入口右侧）绘有唐初长安城示意图和吐蕃婚使智闯五难婚使图等。门庭入口两侧墙壁绘有吉祥回文诗，分别为宗喀巴赞颂词和六字真言图。',20,2),(9,'仁增拉康--持明殿','位于红宫西大殿南侧的仁增拉康(持明殿)即密宗传承殿，建于公元l690-1693年间，主供一尊银质莲花生大师像。此像两旁塑有莲花生的孟加拉密妃拉江?门达绕瓦和藏妃康卓?益西措杰塑像。其右侧排列古印度八持明传承师(密宗的正统继承者和传播者)的铜鎏金像，左侧排列古如八名号(古如即梵语上师之意)即莲花生八大化身。八持明传承师塑像前有八善逝银质佛塔，古如八名号塑像前排有三怙主(文殊菩萨、观音菩萨、金刚手菩萨)塑像；该殿东、西、北面墙壁处设有书架，装满金汁、银汁、朱砂等写就的经典，共计2500多部。',20,2),(10,'冲绕拉康--观世音本生殿','位于红宫西大殿北侧的冲绕拉康，建于公元1690-1693年间，面积达214平方米。殿内供奉一尊纯金释迦牟尼像，一世至五世达赖喇嘛塑像及十一世达赖喇嘛克珠嘉措灵塔等。该殿东侧和北侧设有经书架，上置典籍1000余,部，多为缮本，内容涉及宗教、文化、艺术、工匠、医学、语言等学科。其中，公元1725年清雍正帝赐赠七世达赖喇嘛的一套北京版藏文《丹珠尔》经和西藏首部刻板《丹珠尔》经尤为珍贵。殿门外悬挂有清雍正帝所赐《大悲超宗》金字牌匾。',20,2),(11,'五世达赖喇嘛灵塔殿','位于红宫西大殿西侧的五世达赖喇嘛灵塔殿，建于公元1690-1693年间，外观四层，通体一堂，是布达拉宫著名的殿堂之一。殿内供奉五世、十世、十二世达赖喇嘛金质灵塔及八座银质善逝佛塔。在灵塔和佛塔前除供奉有八宝吉祥徽、八瑞相、七政宝、五妙欲等银鎏金浮雕供品1640多部，这些经典中包括《甘珠尔》《丹珠尔》《大般若》、《八千颂》等珍贵佛学典籍，四周壁画主要是无量寿佛。',20,2),(12,'朗仁拉康--菩提道次第殿','位于红宫西大殿东侧的菩提道次第殿，建于公元1690-l693年间，该殿主尊为格鲁派(黄教)创始人宗喀巴银质塑像，其右边供有广行派(由弥勒15授，经无著、世亲等人传出的大乘佛教修行次第)诸上师塑像；其左边供有深观派(由文殊口授。经龙树师徒辗转传出的大乘佛教最高哲学)诸上师塑像一共68尊。因宗喀巴大师于公元1409年创建格鲁巴(格鲁派)其著作《菩提道次第广论》(详细论述循序渐进地修佛进程和内容)和《菩提道次第密宗广论》成为格鲁派的主要佛学经典，该殿故得名菩提道次第殿。',20,2),(13,'四方街','四方街，位于丽江古城中心，交通四通八达，周围小巷通幽，据说是明代木氏土司按其印玺形状而建。这里是茶马古道上最重要的枢纽站。明清以来各方商贾云集，各民族文化在这里交汇生息，是丽江经济文化交流的中心。\r\n四方街以彩石铺地，清水洗街，日中为市，薄暮涤场的独特街景而闻名遐迩。其四周6条五彩花石街依山随势，辐射开去，街巷相连。四通八达，交通极为便利。\r\n',50,3),(14,'木府','木府是丽江木氏土司衙门的俗称，位于丽江古城狮子山下，是丽江古城文化之\"大观园\"。 整个建筑群坐西向东，是一座辉煌的建筑艺术之苑。\r\n纳西族人原来没有汉族的姓氏，朱元璋建立明王朝后，远在滇西北丽江纳西族土司阿甲阿得审时度势，于公元1382年\"率从归顺\"，举人臣之礼，此举大获朱元璋赏识，朱将自己的姓去掉一撇和一横，钦赐其汉姓\"木\"，从此纳西传统的父子连名制得以改成汉姓名字。\r\n木府是一座辉煌的建筑艺术之苑，它充分反映了明代中原建筑的风采气质，同时保留了唐宋中原建筑古朴粗犷的流风余韵，而其坐西朝东，府内玉沟纵横，活水长流的布局，则又见纳西族传统文化之精神。 丽江旅游有一句话：\"不到木府，等于不到丽江\"。\r\n',40,3),(15,'雪山书院','雪山书院是雍正元年(1723年)改土归流后，丽江首任流官知府杨馝所创建。此之后至光绪年间，雪山书院经历了多次的修葺、扩张和改建，特别是在光绪十九年(1893年)，知府陈宗海、晚清进士和庚吉，雪山书院山长李福宝，在书院原基础上作改建，藏书楼十分为之壮观，教室宽敞，门楼更高大。\r\n直到1905年的停科举、兴学校，其使命才告结束，办学历史长达180年。期间，共培养出了2名翰林，7名进士，61名举人，12名副榜，154名贡生，其余廪生、增生、附生难以计数，正是这些边疆人才推动了纳西族地区文化教育事业的发展，也体现古代丽江平民子弟从此能够普遍接受汉文化教育的一个重要标志。\r\n',0,3),(16,'黑龙潭','黑龙潭又名玉泉公园、旧名玉泉龙王庙，始建于乾隆二年（1737），其后乾隆六十年、光绪十八年均有重修记载，因获清朝嘉庆、光绪两朝皇帝敕封\"龙神\"而得名，后改称黑龙潭。\r\n黑龙潭位于城北象山脚下，从丽江古城四方街沿经纬纵横的玉河溯流而上，约行一公里有一处晶莹清澈的泉潭，即为中外闻名的黑龙潭，古建筑包括龙神祠、得月楼、锁翠桥、玉皇阁，以及后来迁建于此的原明代芝山福国寺解脱林门楼、五凤楼，原知府衙署的明代光碧楼及清代听鹂榭、一文亭、文明坊等建筑。\r\n',0,3),(17,'西湖断桥','断桥残雪为西湖十景之一。断桥位于白堤东端，南宋时又名宝祐桥，也称为段家桥。今桥为1941年重建。桥畔有\"云水光中\"水榭和断桥残雪碑亭。断桥残雪景观内涵说法不一，一般指冬日雪后，桥的阳面冰雪消融，但阴面仍有残雪似银，从高处眺望，桥似断非断。伫立桥头，放眼四望，远山近水，尽收眼底，是欣赏西湖雪景之佳地。 五十年代又经修饰 。桥的东北有碑亭，内立\"断桥残雪\"碑。',0,4),(18,'雷峰塔','雷峰塔又名皇妃塔、西关砖塔，位于浙江省会杭州市西湖风景区南岸夕照山的雷峰上。雷峰塔初建于公元977年，是吴越忠懿王钱俶为供奉佛螺髻发舍利而建。相传为庆祝宠妃黄氏得子而建,所以命名为\"皇妃塔\"。后来，因其所在的山峰叫\"雷峰\"，而逐渐被人们称为\"雷峰塔\"。\r\n中国民间故事《白蛇传》中，法海和尚骗许仙至金山，白娘子水漫金山救许仙，被法海镇在雷峰塔下。\r\n旧雷峰塔于1924年倒塌，后重建，新建的雷峰塔为中国首座彩色铜雕宝塔。雷峰夕照为西湖十景之一，是杭州市西湖著名旅游景点之一。\r\n',80,4),(19,'钱王祠','钱王祠始建于北宋熙宁十年（公元1077年），是后人为纪念吴越国钱王功绩而建造的。900多年来，历经沧桑，几经毁建，所存八字墙是原建筑仅存遗迹。\r\n杭州市政府为挖掘杭州的历史文化内涵，恢复历史文化景观，于2001年在钱王祠旧址---西湖南线柳浪闻莺公园重建这座古祠，并经专家设计、市民评选，最后确定了重建方案。重建工程于2002年2月动工，至2003年国庆前夕竣工落成。\r\n古祠恢复了吴越国钱氏三世五王塑像、功德崇坊，主要殿堂建筑等相应景观。重建后的钱王祠占地11300 平方米，建筑面积4600平方米。同时在祠内陈列钱氏相关的史迹，并以声、光、电的高科技手法再现\"钱王修筑海塘\"等历史场景，古韵浓郁，情趣盎然。此外，古祠内还建造了古戏台，演出《钱镠记》和一些昆曲、京剧、越剧等，让游客欣赏。重建的钱王祠与柳浪闻莺公园融为一体，已成为集游览、观赏、文化展示、历史研究为一体的园林新景点。\r\n钱王祠不仅丰富了西湖南线景区的历史遗存，而且对于推动杭州文化重建起着积极的作用。\r\n',15,4),(20,'净慈寺','净慈寺，位于浙江省杭州市的西湖南岸，雷峰塔对面，是西湖历史上四大古刹之一，中国著名寺院之一。因为寺内钟声洪亮，所以\"南屏晚钟\"成为\"西湖十景\"之一，该寺在浙江杭州的南屏山慧日峰下，是公元954年五代吴越国钱弘俶为高僧永明禅师而建，原名永明禅院；南宋时改称净慈寺，并建造了五百罗汉堂。\r\n净慈寺，屡毁屡建，寺宇、山门、钟楼、后殿、运木古井和济公殿，都是二十世纪八十年代重建的，大雄宝殿单层重檐，黄色琉璃瓦脊，更显庄严宏传。特别是一口重达一百多公斤的新铸铜钟，铸有赵朴初等人书写的《妙法莲华经》，计六点八万字，每日黄昏，悠扬的钟声在暮色苍茫的西湖上空荡，激起人们的无限遐思。\r\n',15,4),(21,'十八盘','十八盘之于泰山，正如八达岭之于长城；兵马俑bai之于西安，它是泰山登山盘路中最险要的一段，也是泰山的主要标志之一，更是泰山最值的一走的景点。从对松山谷底至南天门的山路统称为\"十八盘\"，共有1600多级台阶。前393级称慢十八盘；中767级为不紧不慢十八盘；后473级为紧十八盘。',0,5),(22,'南天门','南天门位于泰山十八盘的尽头，是登山盘道顶端，此处双峰夹峙，仿佛天门自开。由下仰视犹如天上宫阙，所以取仙境场所命名。穿过南天门就是泰山山顶，登山行程正式完成.南天门分上下两层。',0,5),(23,'玉皇顶','玉皇顶位于碧霞祠北，旧称太平顶，又名天柱峰，是泰山主峰之巅。因峰顶有玉皇庙而得名，为泰山绝顶，海拔1545米，气势雄伟，拔地而起，有\"天下第一山\"之美誉。 玉皇庙位于玉皇顶上，古称太清宫、玉皇观，始建年代现已不可考，明成化年间重修。主要建筑有玉皇殿、迎旭亭、望河亭、东西配殿等。',0,5),(24,'中天门','中天门是泰山登山东、西两路的交汇点，也是盘山公路终点。此处为登顶半程，上下必经之地。中天门建于清，为两柱单门式石坊。泰山古时多虎，古人在坊北建庙祀黑虎神，现庙内塑财神赵公元帅执鞭跨虎，东为仿古茶楼，西南为中溪宾馆，西北为中天门索道站。',0,5),(25,'天烛峰','天烛峰位于九龙岗南崖上，两座峰相距不远、隔涧相望、形状近似巨烛的山峰，分别被称为大天烛峰、小天烛峰。大、小天烛峰附近是泰山欣赏古松的绝佳所在，后石坞古松园就在这里，还有三池碧水。南为鉴池，传说为元君梳洗映容之处，又名玉女洗头盆，北为凤凰池，东北为饮虎池。',0,5),(26,'亚龙湾','亚龙湾为一个月牙湾，拥有7千米长的银白色海滩，沙质相当细腻。而这里的南海没有受到污染，海水洁净透明，远望呈现几种不同的蓝色，而水面下珊瑚种类丰富，可清楚观赏珊瑚，适合多种水面下活动包括潜水等，令海底成为了当地的旅游的核心。岸上林木郁郁葱葱。冬季这里的气温27摄氏度，水温20摄氏度，是一处理想的冬季避寒和休闲度假胜地。号称\"东方夏威夷\"。沿海岸一带布满多座高级酒店，包括国际五星级的假日酒店。',69,6),(27,'三亚湾','三亚湾度假区紧挨三亚市区，绵延22公里。该湾湾长沙细，岸上绿树如带，构成三亚滨海旅游城市美丽动人的风景线。市内道路直通海边，将建成3个临海的广场和一个滨海公园。长长海湾，规划分为三段，紧连市区一段为游乐观光漫游区域，稍远为公共海边泳场和海上活动区域，再远是拥有一批度假村的休闲度假区域。',0,6),(28,'天涯海角','天涯海角游览区位于海南省三亚市西南方向23千米处，位于三亚湾和红塘湾之间的岬角上。总面积为16.4平方千米，其中陆域面积10.4平方千米，海域面积为6平方千米。因景区两块巨石分别刻有\"天涯\"、\"海角\"及郭沫若先生题写的\"天涯海角游览区\"而得名。 \r\n天涯海角的自然景观是由大型海滩岩、下马岭、天涯湾以及沙滩和海水组成。  游览区主要有\"天涯\"石、\"海角\"石、\"南天一柱\"等景点。\r\n',81,6),(29,'大小洞天','大小洞天风景区，原名海山奇观风景区，古称鳌山大小洞天，位于海南省三亚市区以西40公里的南山西南隅，总面积为22.5平方公里，景区已有800多年历史，是著名的道教文化风景区。\r\n大小洞天风景区以其秀丽的海景、山景和石景号称琼崖第一山水名胜。风景区内仍有\"小洞天\"、\"钓台\"、\"海山奇观\"、\"仙人足\"、\"试剑峰\"等历代诗文摩崖石刻。山、海、林泉是构成一个旅游名胜必不可少的条件。这里，崖州湾弧弦百里，碧波万倾；鳌山云深林翠，岩奇洞幽；海岸遍布神工鬼斧，肖形状物之大小磊群；山海之间宛如一幅古朴雄壮的长卷画图。\r\n',130,6),(32,'user','Test',200,1);
/*!40000 ALTER TABLE `attraction_project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `catering`
--

DROP TABLE IF EXISTS `catering`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `catering` (
  `catering_id` int NOT NULL AUTO_INCREMENT,
  `catering_name` varchar(30) DEFAULT NULL,
  `catering_information` varchar(500) DEFAULT NULL,
  `catering_price` decimal(9,0) DEFAULT NULL,
  `tour_id` int DEFAULT NULL,
  PRIMARY KEY (`catering_id`),
  KEY `tour_id` (`tour_id`),
  CONSTRAINT `catering_ibfk_1` FOREIGN KEY (`tour_id`) REFERENCES `tour` (`tour_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `catering`
--

LOCK TABLES `catering` WRITE;
/*!40000 ALTER TABLE `catering` DISABLE KEYS */;
INSERT INTO `catering` VALUES (2,'泰国马沙文咖喱','泰国著名的四种咖喱，黄咖喱、红咖喱、绿咖喱和Massaman咖喱（音译马沙文咖喱）。\r\n在国内的泰国餐厅，你一定可以找到前三种咖喱，却未必能找到Massaman咖喱。Massaman咖喱被誉为咖喱之皇，在我来到泰国后，室友带我吃的第一道咖喱就是它，从此就变成了我最喜欢的咖喱。\r\nMassaman咖喱受到了马来菜及印度菜的影响，据说是因为17世纪的商业贸易，给泰国带来了南亚及西亚的香料。如今的泰国南部有很多马来人，因此Massaman也是泰国南部十分出名的料理，主料以鸡肉和牛肉为主（宗教缘故不用猪肉）。\r\n我个人觉得Massaman咖喱和红咖喱有点像，包括从咖喱酱的配方上来看也有不少相同之处。如果你喜欢红咖喱，Massaman咖喱应该也会对你的胃口\r\n',99,3),(3,'那不勒斯披萨','那不勒斯比萨（Neapolitan Pizza /Pizza Napoletana)是用西红柿和马苏里拉芝士制作。配料可以是圣马扎诺西红柿（一种长在维苏威火山南部平原的长而少汁的西红柿）和坎帕纳水牛奶马苏里拉芝士（水牛奶来自坎帕尼亚和拉齐奥的半野生州中的沼泽地，如今马苏里拉已被欧洲原产地保护标',99,1),(4,'墨西哥巧克力','墨西哥巧克力是一种用特种酱料调制的，味道很独特、浓厚的巧克力。我们可以在很多地方看到这种巧克力，尤其是那些售卖墨西哥食物的地方。它通常是块状的固体巧克力，上面有粉和糖浆。除了被用于制作热巧克力，墨西哥巧克力也可以用来制作传统的墨西哥菜像摩尔酱，也可为烘烤食品增添独特的风味。',50,5),(6,'北京烤鸭','烤鸭是具有世界声誉的北京著名菜式，起源于中国南北朝时期，《食珍录》中已记有炙鸭，在当时是宫廷食品。用料为优质肉食鸭北京鸭，果木炭火烤制，色泽红润，肉质肥而不腻，外脆里嫩。北京烤鸭分为两大流派，而北京最著名的烤鸭店也即是两派的代表。它以色泽红艳，肉质细嫩，味道醇厚，肥而不腻的特色，被誉为“天下美味”。',300,2),(7,'日本寿司','寿司是在饭里放醋做主材料的日本料理，寿司和其他日本料理一样，色彩非常鲜明。制作时，把新鲜的海胆黄，鲍鱼，牡丹虾，扇贝，鲑鱼籽，鳕鱼鱼白，金枪鱼，三文鱼等海鲜切成片放在雪白香糯的饭团上，一揉一捏之后再抹上鲜绿的芥末酱，最后放到古色古香的瓷盘中……如此的色彩组合，是真正的“秀色可餐”。 吃寿司，讲究的是食用的完整，就是整块寿司要一口吃下，唯其如此，才能真正的品味出寿司的美味，寿司的饭香与生鱼片的香味才能完全相融，将齿颊间填得满满，不留一丝缝隙，那浓香的滋味无处可逃，在口中久久徘徊。\r\n\r\n',50,4),(8,'冬荫功汤','冬荫功汤是一道泰国名汤，典型的泰国菜，是世界十大名汤之一，在泰语中，“冬荫”指酸辣，“功”即是虾，合起来就是酸辣虾汤了。冬荫功汤是将辅料放入桶煲至出味，而后放入大头虾、鱼露、草菇、花奶、椰汁等一起炖煮，酸味鲜美开胃。这汤以色泽全红，汤味馥郁可口，辣度十足的为佳。',50,6),(9,'越南河粉','越南河粉是越南百年经典美食，融入了中国和法国的烹饪文化，凭借其独到而特别的味道越南河粉在越南大名鼎鼎，属越南的国食。最早是由广东移民在20世纪初期带入越南。\r\n\r\n',30,6),(10,'法国鹅肝','鹅肝一般重达600到900克，不过有些来自Toulouse和Strasbourg地区的鹅，肝据说有2公斤重！用来作鹅肝的鹅并不多，而且体型要够大才能制造出足够重的鹅肝。除了重量外，鹅肝的颜色也很重要，受伤或有损坏的鹅肝是不被采用的，只有纯鹅或鸭肝才能被当作是“Foie Gras”出售，“Gras”这个词在法语里意味“脂肪的”。\r\n料理鹅肝是一种从被过份喂饲的鹅取出来的肝。欧洲人将鹅肝与鱼子酱、松露并列为“世界三大珍馐”。\r\n',1000,5),(11,'土耳其烤肉','土耳其烤肉来自在世界上世界三大菜系之一的土耳其菜系。故在正宗土耳其烤肉是以牛羊肉，鸡肉，鱼肉为食材的。（世界三大菜系：世界三大菜系是指中国菜系，土耳其菜系，法国菜系。）\r\n土耳其烤肉的流行还离不开一个国家，那就是德国。由于二战后土耳其移民在德的增多，土耳其烤肉也开始流行，并且有了西式的创新。如酱汁和里面沙拉的大众化，品种多元化等.\r\n',60,5),(12,'甜甜圈','甜甜圈，又称多拿滋、唐纳滋，它是一种用面粉、白砂糖、奶油和鸡蛋混合之后再经过油炸的甜食。甜甜圈最普遍的两种形状是中空的环状、或面团中间有包入奶油、蛋浆（泛指蛋打成的液体）等甜馅料的封闭型甜甜圈。\r\n甜甜圈在美国还是最为受欢迎的一种甜品，任何一个糕点店铺或快餐店都有出售。从5岁儿童到75岁老人都对它有着一致的热爱。在亚洲，甜甜圈主要是被当成点心类的食物，但在美国则有许多人以甜甜圈作为早餐的主食，甚至还设立了“甜甜圈日”。\r\n',40,3),(13,'鱼子酱','鱼子酱堪称“脆弱的佳肴”，若加工过程中有任何闪失就会导致身价全无。将鱼卵加工成鱼子酱，必须在15分钟内完成十多道工序。首先要把鲟鱼击昏，因为在自然反射下它会分泌出大量的肾上腺素，这将破坏鱼子酱鲜美的原味。随后经过取鱼卵、筛检、清洗、滤干……再由鱼子酱大师嗅、尝、看、摸，评定等级，决定至关重要的一件事——放多少盐。由于品质越好的鱼卵，用的盐越少，所以Almas的含盐量非常之低，其拿捏程度愈发锱铢必较。最后鱼子酱被小心翼翼地层层叠放(免得把下层鱼卵压破)，装进罐子，送上冷冻车，运往全球备受荣宠的商号。而这些商号的主顾，都是付得起一小口数百美金的',2000,3),(14,'黑松露','人类食用黑松露已有2000多年的历史，其中以法国、意大利、西班牙最为盛行。在欧洲鲜食黑松露时,先用特殊的切片器将新鲜黑松露切成极薄的薄片，然后与黄油、意大利干奶酪一起撒在宽面条或者意大利空心粉上,据说味道很棒。法国传统的食用方法是用黑松露煎蛋,将鲜黑松露切成小丁块放入鸡蛋中搅拌均匀，放置过夜使黑松露的味道充分进入鸡蛋液中，然后常规煎炒即可。作为名菜, 用黑松露做汁配牛排在法国和意大利高级餐厅里非常有名。',300,1);
/*!40000 ALTER TABLE `catering` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hotel`
--

DROP TABLE IF EXISTS `hotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hotel` (
  `hotel_id` int NOT NULL AUTO_INCREMENT,
  `hotel_name` varchar(30) DEFAULT NULL,
  `hotel_information` varchar(500) DEFAULT NULL,
  `hotel_price` decimal(9,0) DEFAULT NULL,
  `tour_id` int DEFAULT NULL,
  PRIMARY KEY (`hotel_id`),
  KEY `tour_id` (`tour_id`),
  CONSTRAINT `hotel_ibfk_1` FOREIGN KEY (`tour_id`) REFERENCES `tour` (`tour_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel`
--

LOCK TABLES `hotel` WRITE;
/*!40000 ALTER TABLE `hotel` DISABLE KEYS */;
INSERT INTO `hotel` VALUES (2,'四季酒店','伦敦公园路四季酒店(Four Seasons Hotel London at Park Lane)经过2亿美元的重新整修，如今已成为全球奢华酒店的代表。Four Seasons Hotel London at Park Lane到处充满清新，艳丽的绿色，与海德公园相映生辉，让人们体验到四季酒店的别致美景。奢华舒适的客房、优雅的餐厅、美丽的室内花园、屋顶温泉透过360度玻璃幕墙俯览公园全景，训练有素的员工提供给客户最贴心的关怀，这一切使其成为伦敦最好的酒店之一。',2800,3),(3,'巴黎香格里拉酒店','巴黎香格里拉酒店（Shangri-La Hotel, Paris）距离埃菲尔铁塔和塞纳河仅600米，其绿意盎然的典雅客房和套房都享有艾菲尔铁塔的浪漫景色。您可以在La Bauhinia餐厅享用法式和亚洲美食；在L’Abeille餐厅品尝法国美食，在Shang Palace餐厅品尝正宗的粤菜。 您还可以在玻璃屋顶的餐厅享用早餐、午餐和晚餐。Le Bar酒店为客人提供私人休息室。',3000,3),(5,'印度泰姬陵皇宫酒店','印度泰姬陵皇宫酒店（Taj Falaknuma Palace）位于印度南部的海得拉巴山（Hyderabad）上，这里拥有丰富的历史遗迹、闻名的美味佳肴、以及众多世界大牌科技公司（谷歌，戴尔，和摩托罗拉等）。falaknuma宫建于1884麦布布阿里汗，曾是国王爱德华八世和沙皇尼古拉斯二世喜爱的住所，拥有巨大的花园和图书馆。以前曾被大火烧掉，如今经过十年的精心重建，已经恢复了往日的光辉，这就是世界顶级的酒店：印度泰姬陵皇宫酒店（Taj Falaknuma Palace）。',2500,6),(8,'香港丽思卡尔顿酒店','香港丽思卡尔顿酒店 | 位于环球贸易广场顶部102层至118层，由美国豪华酒店品牌丽思卡尔顿酒店集团经营。香港丽思卡尔顿酒店共有312个房间，普通套房“起步价”为每晚6000港元，而入住顶级总统套房的花费则达到每晚10万港元。香港丽思卡尔顿酒店大堂所在楼层海拔超过400米，成为全球位处楼层最高的酒店。',1500,5),(10,'阿玛尼酒店','意大利时尚设计师乔治·阿玛尼也在大厦内建起第一家阿玛尼酒店，成为阿玛尼酒店全球连锁的旗舰店，内部所有的装潢、家具设计全部遵循阿玛尼品牌的风格。阿玛尼酒店内包括有175间贵宾间和套房，除此之外还有餐厅、温泉等，占地共达4万平方米。在酒店的旁边还有144座豪华的住宅式公寓，从家具到所有其它产品的设计也都由阿玛尼亲自操刀',2000,1),(11,'上海柏悦酒店','上海柏悦酒店 | 是一座精致的摩登中国式住宅酒店，位于有(垂直型综合城区)之称的上海环球金融中心79至93楼，是一座精致的摩登中国式住宅酒店。位于浦东陆家嘴金融中心地带的上海环球金融中心楼高101层，高492米，上海柏悦酒店将成为世界最高的酒店，拥有174间客房(包括34间套房)。',1200,2),(12,'阿拉伯塔酒店','阿拉伯塔酒店（Burj Al Arab），因外形酷似船帆，又称迪拜帆船酒店，位于阿联酋迪拜海湾，以金碧辉煌、奢华无比著称。酒店建在离沙滩岸边280米远的波斯湾内的人工岛上，仅由一条弯曲的道路连接陆地，酒店共有56层，321米高，酒店的顶部设有一个由建筑的边缘伸出的悬臂梁结构的停机坪。\r\n\r\n',5000,1),(13,'洲际酒店','洲际酒店集团InterContinental Hotels Group PLC (IHG)是一个全球化的酒店集团，在全球100多个国家和地区经营和特许经营着超过4,400家酒店，超过660,000间客房。\r\n“洲际”旗下的酒店品牌有洲际酒店及度假村（InterContinental Hotels & Resorts），假日酒店及假日度假酒店（Holiday Inn），皇冠假日酒店（Crowne Plaza Hotels），智选假日酒店（Holiday Inn Express），英迪格酒店(Indigo) 。\r\n',3000,3),(14,'半岛酒店','半岛酒店（The Peninsula Hotels）是香港现存历史最悠久的的酒店，也是香港以至全球最豪华、最著名的酒店之一。已经有在香港，纽约，芝加哥，比佛利山，东京，曼谷，北京，马尼拉(Manila)，上海等9家半岛酒店。巴黎半岛酒店在2012开业，香港半岛酒店位于九龙尖沙咀梳士巴利道22号，面对维多利亚港，中高层享有海景。酒店有300间客房，客房面积较香港一般酒店大。设施包括罗马宫廷风格的游泳池及健身俱乐部。地下商场多是名牌店。\r\n\r\n',4000,3),(15,'摩洛哥皇家曼苏尔酒店','摩洛哥皇家曼苏尔酒店（Royal Mansour Marrakech）位于摩洛哥马拉喀什城市中心，约3.5公顷，由摩洛哥国王穆罕默德六世建造。步行至著名的La Koutoubia清真寺只需很短时间。酒店设有温泉、餐厅，酒吧，休息室和图书馆。皇家曼苏尔酒店的环境十分优雅和富有魅力。酒店客房多采用软装饰，如丝绸，锦缎，古董和手工制作的家具。客房外面有供客人散步的庭院，水池，喷泉和花园。摩洛哥皇家曼苏尔酒店是一个奢华的世界，一个充满魅力的地方',15000,2),(16,'迈阿密酒店','The Villa by Barton G.酒店可以说是美国乃至全球最奢华的酒店之一，她坐落于美国迈阿密海滩，背靠美丽的大花园。酒店内部的装饰及图案全部由世界顶级的“范思哲”公司设计，采用纺织，壁画和马赛克等等构成，奢华无比。酒店配备舒适的豪华大床，还有电子报纸，露天的SPA和泳池可以尽览迈阿密海滩。',2000,2),(17,'深圳瑞吉酒店','深圳瑞吉酒店 | 坐落于罗湖区蔡屋围金融中心区，于2011年12月18日正式开业，酒店占据京基100大厦的第75至100层，是中国大陆最高的酒店。深圳瑞吉酒店拥有 297 间客房和套房，不仅拥有舒适时尚的幽居环境，还可饱览壮丽迷人的城市美景，内部设有5家餐厅和酒吧，还设有水疗护理，健身俱乐部。酒店大堂位于京基100大厦的96层。',2000,1);
/*!40000 ALTER TABLE `hotel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tour`
--

DROP TABLE IF EXISTS `tour`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tour` (
  `tour_id` int NOT NULL AUTO_INCREMENT,
  `tour_name` varchar(30) DEFAULT NULL,
  `tour_price` decimal(9,0) DEFAULT NULL,
  `tour_phone` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`tour_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tour`
--

LOCK TABLES `tour` WRITE;
/*!40000 ALTER TABLE `tour` DISABLE KEYS */;
INSERT INTO `tour` VALUES (1,'扬州舜天国际旅行社',996,'89880101 '),(2,'新疆中国旅行社有限公司',666,'13565990098'),(3,'甘肃漫步国际旅行社',466,'7804003 '),(4,'吉林省中国旅行社',598,'81884379'),(5,'山西新华国际旅行社',310,'18935128321'),(6,'湖南中铁国际旅行社',488,'89715147'),(7,'ogtwelve',123,'18736262110');
/*!40000 ALTER TABLE `tour` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction` (
  `transaction_id` int NOT NULL AUTO_INCREMENT,
  `transaction_information` varchar(200) DEFAULT NULL,
  `account_id` int DEFAULT NULL,
  PRIMARY KEY (`transaction_id`),
  KEY `account_id` (`account_id`),
  CONSTRAINT `transaction_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transfer`
--

DROP TABLE IF EXISTS `transfer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transfer` (
  `transfer_id` int NOT NULL AUTO_INCREMENT,
  `transfer_name` varchar(30) DEFAULT NULL,
  `transfer_information` varchar(500) DEFAULT NULL,
  `transfer_price` decimal(9,0) DEFAULT NULL,
  `tour_id` int DEFAULT NULL,
  PRIMARY KEY (`transfer_id`),
  KEY `tour_id` (`tour_id`),
  CONSTRAINT `transfer_ibfk_1` FOREIGN KEY (`tour_id`) REFERENCES `tour` (`tour_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transfer`
--

LOCK TABLES `transfer` WRITE;
/*!40000 ALTER TABLE `transfer` DISABLE KEYS */;
INSERT INTO `transfer` VALUES (1,'巴士','双层巴士',2,3),(2,'轻轨','城市轻轨',53,3),(3,'地铁','城市地铁',4,1),(5,'BRT','快速公交',2,6),(6,'飞机','波音747',2000,3),(12,'jss','111',22,4);
/*!40000 ALTER TABLE `transfer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) DEFAULT NULL,
  `user_password_encryption` varchar(32) DEFAULT NULL,
  `user_password_key` varchar(10) DEFAULT NULL,
  `user_admin` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'测试1','8ae4eb923922cfd517927482ff76d712','j963w98q5k','T'),(2,'王佳宝','9506ed9a17d766b3b63bb2b7f7259186','n22d1FA6M8','T'),(5,'ogtwelve1','b7d51ae35f7b9bfd1b82952d84fe3256','73rmtFkFPk','T'),(6,'添加测试','164c48ea750f009e0563b1dde776a047','BMB4e1Y2fg','T'),(8,'325添加测试','8d60cf27742cbf49ad2afceef4f85819','3BLnfYFPAy','F'),(9,'ogtwelve','93d842d53defad3bcdb291cb2aa10c78','WEnmrde7Hw','T'),(10,'67添加测试','5cef28d6f4b8fc214d94f26d0defabcc','WWGGe5gaY8','F');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-16 19:44:57
