package com.boot;

import com.alibaba.fastjson.JSONArray;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

/**
 * @author l.tian@aftership.com
 * @date 2020/8/24
 */
public class FixBrokerLinkTest {
    public static void main(String[] args) {

        String brokerlinkJson = "[\n" +
                "\n" +
                "{\"providerId\":\"google\",\"userId\":\"997d84f0437d49c4a24904771d269179\",\"email\":\"business@zeroforfive.com\",\"brokerUserId\":\"102166296194109667969\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"google\",\"userId\":\"406b6ba5056145a8957643c3a6fdbecc\",\"email\":\"vritika.sharma@aftership.com\",\"brokerUserId\":\"102775574078400094941\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"google\",\"userId\":\"f7c7079eb9994d108a48af8e5827e1b4\",\"email\":\"vritika.sharma@aftership.com\",\"brokerUserId\":\"102775574078400094941\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"google\",\"userId\":\"689a58c60d054fc5b021c71758ab0d19\",\"email\":\"happyplacesuppliers@gmail.com\",\"brokerUserId\":\"103357990101391852895\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"google\",\"userId\":\"bf3f2af25c7f4affa2d407f26089188b\",\"email\":\"happyplacesuppliers@gmail.com\",\"brokerUserId\":\"103357990101391852895\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"google\",\"userId\":\"28589c992c4e4979911e7b5afbe1f664\",\"email\":\"happykevinmeyer@gmail.com\",\"brokerUserId\":\"103507057539791779248\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"google\",\"userId\":\"d423fc35f21643c6b12d26985f95c256\",\"email\":\"happykevinmeyer@gmail.com\",\"brokerUserId\":\"103507057539791779248\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"google\",\"userId\":\"55644303f73048d6afea941c72c30588\",\"email\":\"vritikasharma.95@gmail.com\",\"brokerUserId\":\"106009349914633763825\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"google\",\"userId\":\"c7fd4d0c715a45cc965855237bf1db45\",\"email\":\"vritikasharma.95@gmail.com\",\"brokerUserId\":\"106009349914633763825\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"google\",\"userId\":\"879075fa9b3a484dad3c61c9f0aec6fc\",\"email\":\"cassandylangs@gmail.com\",\"brokerUserId\":\"106675785775621604890\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"google\",\"userId\":\"a7e8c5f33a9d4aa19bfdb54a86a746f0\",\"email\":\"cassandylangs@gmail.com\",\"brokerUserId\":\"106675785775621604890\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"google\",\"userId\":\"a39e9d79b6504fd889016cc45712f94f\",\"email\":\"leshana28@gmail.com\",\"brokerUserId\":\"109244100691233574580\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"google\",\"userId\":\"e49aa7c86e4a421b9ad465caa406a883\",\"email\":\"leshana28@gmail.com\",\"brokerUserId\":\"109244100691233574580\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"google\",\"userId\":\"8d4d45d577534d1ca7c8bec468540c7a\",\"email\":\"4mostip@gmail.com\",\"brokerUserId\":\"110779423331010385407\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"google\",\"userId\":\"a00e88a3280b4c298ec94ab5bfc1cea5\",\"email\":\"4mostip@gmail.com\",\"brokerUserId\":\"110779423331010385407\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"google\",\"userId\":\"6ad9e335baf546e9bc850caf9cf69149\",\"email\":\"seemaamola123@gmail.com\",\"brokerUserId\":\"111411364216794953344\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"google\",\"userId\":\"b4f570a0c5e8482990d5d35e3c2cb31a\",\"email\":\"seemaamola123@gmail.com\",\"brokerUserId\":\"111411364216794953344\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"google\",\"userId\":\"5408386eaf1f4bcba0b1313e0c2651d4\",\"email\":\"andrew@bluntcanada.ca\",\"brokerUserId\":\"111944199639441765452\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"google\",\"userId\":\"d1a4ef42aa7749ee87df63d4c7abdda5\",\"email\":\"andrew@bluntcanada.ca\",\"brokerUserId\":\"111944199639441765452\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"google\",\"userId\":\"980db8eaaf0c40418130fd303a927f4c\",\"email\":\"thetopref@gmail.com\",\"brokerUserId\":\"117279917544747449352\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"google\",\"userId\":\"a39088146d3b4d3cb93c2b13a81330c1\",\"email\":\"thetopref@gmail.com\",\"brokerUserId\":\"117279917544747449352\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify\",\"userId\":\"006f1780a8ec41a69d811b7a70727cac\",\"email\":\"shopsforgood@gmail.com\",\"brokerUserId\":\"21952137\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify\",\"userId\":\"3dc9d0c051a84df59949b5ede11eff11\",\"email\":\"jennahm.park@gmail.com\",\"brokerUserId\":\"21952137\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:aaeira\",\"userId\":\"302ce092fd48405d9c47ef99582506be\",\"email\":\"harsha.thomas@gmail.com\",\"brokerUserId\":\"40191590472\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:aaeira\",\"userId\":\"cd1c577e376d4dad892cbe662d21cc2c\",\"email\":\"harsha.thomas@gmail.com\",\"brokerUserId\":\"40191590472\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:alayathelabel\",\"userId\":\"bd2a56a5f23b4e668d68fc6be56829c0\",\"email\":\"priyasharma@stage3.co\",\"brokerUserId\":\"60597436573\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:alayathelabel\",\"userId\":\"f0f143f498f644cea64bc6a60e12d15d\",\"email\":\"priyasharma@stage3.co\",\"brokerUserId\":\"60597436573\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:art-of-dp\",\"userId\":\"6dc0c0d975ee4425aeba8329d5d71ee2\",\"email\":\"support@ecommercegroup.ltd\",\"brokerUserId\":\"52613382279\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:art-of-dp\",\"userId\":\"d85e47a698244c2bbcc0d26fa692d740\",\"email\":\"support@ecommercegroup.ltd\",\"brokerUserId\":\"52613382279\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:barketau\",\"userId\":\"55c722b167f941f88ded45d35d3c8871\",\"email\":\"hello@barket.com.au\",\"brokerUserId\":\"29614899300\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:barketau\",\"userId\":\"c3a94058b4ff448199695cd782e555fe\",\"email\":\"hello@barket.com.au\",\"brokerUserId\":\"29614899300\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:bebeandme\",\"userId\":\"bddd77c79cc6484e8492192f42b80711\",\"email\":\"hello@bebeandme.co.uk\",\"brokerUserId\":\"8225292336\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:bebeandme\",\"userId\":\"f05f4a08475c485cbca3a9fc70da5abb\",\"email\":\"hello@bebeandme.co.uk\",\"brokerUserId\":\"8225292336\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:beed-speed\",\"userId\":\"c6e5819592394797b61564b579c68ab8\",\"email\":\"india2@beedspeed.com\",\"brokerUserId\":\"40970682411\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:beed-speed\",\"userId\":\"ca5dd4bf207241debf9a796c9846750e\",\"email\":\"india2@beedspeed.com\",\"brokerUserId\":\"40970682411\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:bloomonmelrose\",\"userId\":\"0646494f004b4fe9a7a77713f9cb21bc\",\"email\":\"rejane@bloomonmelrose.com\",\"brokerUserId\":\"52814023\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:bloomonmelrose\",\"userId\":\"548e8f19da54466e8635e7e1e4ca5728\",\"email\":\"rejane@bloomonmelrose.com\",\"brokerUserId\":\"52814023\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:cervicalcloud\",\"userId\":\"14f6e9c6656940b6959c13cfd5f65a9b\",\"email\":\"apps@aftership.com\",\"brokerUserId\":\"61443375255\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:cervicalcloud\",\"userId\":\"2e44c192fbdd4761907ab292524b1f76\",\"email\":\"apps@aftership.com\",\"brokerUserId\":\"61443375255\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:chillboys\",\"userId\":\"07320527c46e4d34a67802f38741389e\",\"email\":\"julie@chillboys.com\",\"brokerUserId\":\"57326698655\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:chillboys\",\"userId\":\"2e77510da6e84af4aee01ba2bb2ba58e\",\"email\":\"julie@chillboys.com\",\"brokerUserId\":\"57326698655\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:chopperandotis\",\"userId\":\"8934a7259b784b98954d593fb24d71bf\",\"email\":\"jungshan@chopperandotis.com\",\"brokerUserId\":\"412352526\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:chopperandotis\",\"userId\":\"c747b7a20c8248f48ffd3e74f6c4a00e\",\"email\":\"jungshan@chopperandotis.com\",\"brokerUserId\":\"412352526\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:despi-usa\",\"userId\":\"787c01960f7941318d9ec001cf90b685\",\"email\":\"gallapas@gmail.com\",\"brokerUserId\":\"9776726080\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:despi-usa\",\"userId\":\"cbef83e22f05499caa1ec25704c4bf20\",\"email\":\"gallapas@gmail.com\",\"brokerUserId\":\"9776726080\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:emoiemoi-test\",\"userId\":\"c26f24778dd74f57b6cc93eef672b94a\",\"email\":\"victor.couturier@colorz.fr\",\"brokerUserId\":\"54519726125\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:emoiemoi-test\",\"userId\":\"d8181f688c0c4d76a5838fb9b10c83a2\",\"email\":\"victor.couturier@colorz.fr\",\"brokerUserId\":\"54519726125\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:fait-par-une-maman\",\"userId\":\"8b5c6199d6404c708c3b8b38edf57ac8\",\"email\":\"boutique@faitparunemaman.ca\",\"brokerUserId\":\"41895854152\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:fait-par-une-maman\",\"userId\":\"e48c53108e184279a22495545ca17b01\",\"email\":\"boutique@faitparunemaman.ca\",\"brokerUserId\":\"41895854152\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:favour-store1\",\"userId\":\"53333b70cf144514a73f1462ec256c97\",\"email\":\"favouronuorah388@gmail.com\",\"brokerUserId\":\"41504833611\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:favour-store1\",\"userId\":\"f5acd42f157d45d1a6bc3718f1eb5115\",\"email\":\"urwigg@gmail.com\",\"brokerUserId\":\"41504833611\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:furbabycouture\",\"userId\":\"0ebebe3911f74d429869372483dd6f41\",\"email\":\"contact@furbabycouture.com\",\"brokerUserId\":\"112996876\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:furbabycouture\",\"userId\":\"a3a5d67c3552420994ffa748ed393230\",\"email\":\"contact@furbabycouture.com\",\"brokerUserId\":\"112996876\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:fw-test-01\",\"userId\":\"0b3413c6ea484ddca52c4d4affc08274\",\"email\":\"yj.ma+staging@aftership.com\",\"brokerUserId\":\"39695876130\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:fw-test-01\",\"userId\":\"7f2d6ce8f43d438a8a6642371463648f\",\"email\":\"fw.he@aftership.com\",\"brokerUserId\":\"39695876130\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:gaoming-test-multiple-currency\",\"userId\":\"0b3413c6ea484ddca52c4d4affc08274\",\"email\":\"yj.ma+staging@aftership.com\",\"brokerUserId\":\"48600318091\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:gaoming-test-multiple-currency\",\"userId\":\"ad5ab6bbf5aa4a62b69bf51d24014a64\",\"email\":\"m.gao@aftership.com\",\"brokerUserId\":\"48600318091\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:gftech\",\"userId\":\"73abaaf09c574333a4199ecb7459a1d4\",\"email\":\"extremlysales@gmail.com\",\"brokerUserId\":\"54569631902\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:gftech\",\"userId\":\"f1ae0d21faa04ca8898a7c8bb0323d81\",\"email\":\"extremelysales@gmail.com\",\"brokerUserId\":\"54569631902\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:giniartwshop\",\"userId\":\"445b3d58a1044579b9a257b677c4648a\",\"email\":\"kfenlon@fashionata.com.au\",\"brokerUserId\":\"60142452902\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:giniartwshop\",\"userId\":\"b69ca8a7a5eb4ec89f107fdadd86d54e\",\"email\":\"kfenlon@fashionata.com.au\",\"brokerUserId\":\"60142452902\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:golden-wolfe\",\"userId\":\"50c0a0367f2441ee8c675076ba343b52\",\"email\":\"cody@nakedwolfe.com\",\"brokerUserId\":\"54626503\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:golden-wolfe\",\"userId\":\"72c6588331dd47559dd255b4c3f0e48a\",\"email\":\"cody@nakedwolfe.com\",\"brokerUserId\":\"54626503\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:hand-in-pocket\",\"userId\":\"6e948b8f56c14771a98f5ce0da953727\",\"email\":\"n.blochinger@yahoo.com\",\"brokerUserId\":\"39350632515\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:hand-in-pocket\",\"userId\":\"a3f531d952fa472795aed95dffa7911e\",\"email\":\"n.blochinger@yahoo.com\",\"brokerUserId\":\"39350632515\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:hat-club\",\"userId\":\"69ab6ad9687e4bbfa14da7c5ea7cfd96\",\"email\":\"dmarsh@hatclub.com\",\"brokerUserId\":\"39105560651\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:hat-club\",\"userId\":\"90f2faf6a0c24a4bbb00248a32355555\",\"email\":\"ecommadmin@hatclub.com\",\"brokerUserId\":\"39105560651\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:heissen-store\",\"userId\":\"709b4dc977f64b3a9997f2a024b9c8c5\",\"email\":\"contacto@estuyo.com.mx\",\"brokerUserId\":\"40967274574\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:heissen-store\",\"userId\":\"809495d4c6924d4d937be0729e71b353\",\"email\":\"alexisg.estuyomx@gmail.com\",\"brokerUserId\":\"40967274574\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:jayagrocer\",\"userId\":\"850db8ca328247df9ccb69094b5107e9\",\"email\":\"masteradmin@ec.jayagrocer.com\",\"brokerUserId\":\"32011780158\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:jayagrocer\",\"userId\":\"ac7ebc91b70349ee894ef4a72cd067df\",\"email\":\"masteradmin@jayagrocer.online\",\"brokerUserId\":\"32011780158\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:jdr-distributors\",\"userId\":\"823c0586119c4bc79edf920b8da89833\",\"email\":\"shoponlinepr@yahoo.com\",\"brokerUserId\":\"34463055926\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:jdr-distributors\",\"userId\":\"c4f86dddf47844b1813be3cedc9b00c5\",\"email\":\"shoponlinepr@yahoo.com\",\"brokerUserId\":\"34463055926\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:kettleandfire\",\"userId\":\"8f8d2d20135c4917b7e83fbe0f95b919\",\"email\":\"niccolo@bonebroths.com\",\"brokerUserId\":\"22878191733\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:kettleandfire\",\"userId\":\"b5a4ce682fba46b2af4c8be73e9858a2\",\"email\":\"niccolo@bonebroths.com\",\"brokerUserId\":\"22878191733\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:kiravans\",\"userId\":\"11d800583f884f588939ea0f004e6aee\",\"email\":\"robert@kiravans.co.uk\",\"brokerUserId\":\"38429818933\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:kiravans\",\"userId\":\"b9a38f2766834ed8a30975d698c52e95\",\"email\":\"robert@kiravans.co.uk\",\"brokerUserId\":\"38429818933\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:knock-pods\",\"userId\":\"49bb36719fb34f55853131c36c8586e6\",\"email\":\"support@knockpods.com\",\"brokerUserId\":\"40433647727\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:knock-pods\",\"userId\":\"b0bf83d522ea47b9bac7b745bbabcc22\",\"email\":\"support@knockpods.com\",\"brokerUserId\":\"40433647727\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:la-relaxed\",\"userId\":\"577c498a6b964ca28e1640743bd7dd34\",\"email\":\"jesse@larelaxed.com\",\"brokerUserId\":\"41328902237\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:la-relaxed\",\"userId\":\"974c7f41651d49eeb692e2587bbf9888\",\"email\":\"jesse@larelaxed.com\",\"brokerUserId\":\"41328902237\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:layla-collection\",\"userId\":\"12782998067a44eb93df89539d209dfb\",\"email\":\"lielaaraj@gmail.com\",\"brokerUserId\":\"56834654369\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:layla-collection\",\"userId\":\"a3472bd107c94e14a913904d7c632947\",\"email\":\"lielaaraj@gmail.com\",\"brokerUserId\":\"56834654369\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:lens-emporia\",\"userId\":\"050eb07cc7a144fa92ddb4f042c22c52\",\"email\":\"accounts@lensemporia.com\",\"brokerUserId\":\"121567059\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:lens-emporia\",\"userId\":\"0e3a631af05b43f6a3084db5c3f0e1c2\",\"email\":\"accounts@lensemporia.com\",\"brokerUserId\":\"121567059\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:maison-modulare\",\"userId\":\"30d15f7b7ffa425a8095fc93a195ff6f\",\"email\":\"info@modulare.us\",\"brokerUserId\":\"49506975881\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:maison-modulare\",\"userId\":\"bbe8668fa1334f90bf1a681d6d591899\",\"email\":\"info@modulare.us\",\"brokerUserId\":\"49506975881\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:makobi-jeans-usa\",\"userId\":\"12f44486ff434aa0a6375b23973c191a\",\"email\":\"aby@makobiusa.com\",\"brokerUserId\":\"42447667299\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:makobi-jeans-usa\",\"userId\":\"8f24030f09284995b5ccbbf687e583e2\",\"email\":\"aby@makobiusa.com\",\"brokerUserId\":\"42447667299\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:maxi-home-store\",\"userId\":\"5eea5ae10a2e4a36868029bf2cd41f2d\",\"email\":\"korega_378@hotmail.com\",\"brokerUserId\":\"41101590616\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:maxi-home-store\",\"userId\":\"a6c64a762e5f44d0b928705a84ff1436\",\"email\":\"eduardonbaallstar@gmail.com\",\"brokerUserId\":\"41101590616\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:outland-denim-australia\",\"userId\":\"6bcd75975fb54f88b8bdc8ef56c84f2a\",\"email\":\"accounts@outlanddenim.com\",\"brokerUserId\":\"36231086159\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:outland-denim-australia\",\"userId\":\"c9c0d589786b45dca676ce772b941eb0\",\"email\":\"accounts@outlanddenim.com\",\"brokerUserId\":\"36231086159\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:patatasblanco\",\"userId\":\"92d82e944d8343a98733984f74a86c86\",\"email\":\"jableyenda32@gmail.com\",\"brokerUserId\":\"41607397423\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:patatasblanco\",\"userId\":\"ae90d93259b4467e885ca20e0b152b52\",\"email\":\"cristinaperez201990@gmail.com\",\"brokerUserId\":\"41607397423\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:qayrawancaravan\",\"userId\":\"7764e6e973c54ed6bb018bd914ada5a7\",\"email\":\"ali@qayrawan.co\",\"brokerUserId\":\"1174437916\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:qayrawancaravan\",\"userId\":\"acdd34758df54b948ce09539a8d39df9\",\"email\":\"abensaad5@gmail.com\",\"brokerUserId\":\"1174437916\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:salt-and-lace-intimates\",\"userId\":\"1b29a69404654ecdb68b15764fd97687\",\"email\":\"glyselerio@gmail.com\",\"brokerUserId\":\"42467950689\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:salt-and-lace-intimates\",\"userId\":\"a0ae09dd3bd041c09eaee8dd7d0c7d66\",\"email\":\"glyselerio@gmail.com\",\"brokerUserId\":\"42467950689\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:scoreszone\",\"userId\":\"3436228c4f644c35bdcbd11d4331254e\",\"email\":\"scoreszone@hotmail.com\",\"brokerUserId\":\"51718815883\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:scoreszone\",\"userId\":\"da245e134641472cae0cae866083ceb9\",\"email\":\"cyy1270@outlook.com\",\"brokerUserId\":\"51718815883\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:skar-audio\",\"userId\":\"0dd7108a2d884465bcbee7c065015859\",\"email\":\"anthony@skaraudio.com\",\"brokerUserId\":\"42107207727\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:skar-audio\",\"userId\":\"f4479e6b96f947828be4014172c50b73\",\"email\":\"anthony@skaraudio.com\",\"brokerUserId\":\"42107207727\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:smets-store\",\"userId\":\"e8be5f7b504748539a549941e09c4a4e\",\"email\":\"alimou.barry@smets.lu\",\"brokerUserId\":\"41281552495\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:smets-store\",\"userId\":\"f94e99c9ab5b47fbaee805f073b563cb\",\"email\":\"alimou.barry@smets.lu\",\"brokerUserId\":\"41281552495\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:taf-mexico\",\"userId\":\"6511c2e7dbf14e90ba6c3af765b0c079\",\"email\":\"ana.ibarra@posadas.com\",\"brokerUserId\":\"52479066244\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:taf-mexico\",\"userId\":\"78b2c3a3581741f68c031fcc23845d9b\",\"email\":\"ana.ibarra@posadas.com\",\"brokerUserId\":\"52479066244\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:tassenlandat\",\"userId\":\"39adb3efcfed456cb27557cdee8dc98a\",\"email\":\"patriciamagova123@gmail.com\",\"brokerUserId\":\"45967016071\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:tassenlandat\",\"userId\":\"e34d34d64f1b4f1382872a83d4f9a005\",\"email\":\"doggyliciousstore@gmail.com\",\"brokerUserId\":\"45967016071\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:the-beef-market\",\"userId\":\"a5ebceba4cbc4c58a34a4b2141e93528\",\"email\":\"pintsnbottles@gmail.com\",\"brokerUserId\":\"41671098456\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:the-beef-market\",\"userId\":\"b4b45b09376b4bf381a705a3cab71dd0\",\"email\":\"thebeefmarketplace@gmail.com\",\"brokerUserId\":\"41671098456\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:the-frankie-shop-eu\",\"userId\":\"2ae617ca1ce04166a03a562f0ac1bdfb\",\"email\":\"gaelle@thefrankieshop.com\",\"brokerUserId\":\"41925312565\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:the-frankie-shop-eu\",\"userId\":\"87f090ad0c41434ebf5ba010383ed76a\",\"email\":\"gaelle@thefrankieshop.com\",\"brokerUserId\":\"41925312565\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:tm-beauty-bar\",\"userId\":\"5aa8a56a7e3c4690884ac652296be224\",\"email\":\"admin@toskadirect.com\",\"brokerUserId\":\"41691381853\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:tm-beauty-bar\",\"userId\":\"eb7211fe1446468aa7ed9f430be5c2ff\",\"email\":\"admin@tmbeautybar.com\",\"brokerUserId\":\"41691381853\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:touchartist\",\"userId\":\"45e63e0e61b84105ba8b696514d3d835\",\"email\":\"jewelhouse02@gmail.com\",\"brokerUserId\":\"45191168131\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:touchartist\",\"userId\":\"c81de0d2f6cd4910ae84c01ae21aedef\",\"email\":\"jewelhouse02@gmail.com\",\"brokerUserId\":\"45191168131\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:trump-rack\",\"userId\":\"1a0c890cdece464bb9a56a008c38452a\",\"email\":\"ptg.czarinasamson@gmail.com\",\"brokerUserId\":\"40782331947\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:trump-rack\",\"userId\":\"8d7788af7e82468194bc37aedc402a07\",\"email\":\"ptg.czarinasamson@gmail.com\",\"brokerUserId\":\"40782331947\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:tryrecoop\",\"userId\":\"158468d7b1b24c669fc032ba9828a9f0\",\"email\":\"jill@socialpopcreative.com\",\"brokerUserId\":\"40253620260\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:tryrecoop\",\"userId\":\"e7be45e59ee64b0b87bacf721a6e776c\",\"email\":\"jill@socialpopcreative.com\",\"brokerUserId\":\"40253620260\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:tysadesigns\",\"userId\":\"26512f17d03f4b2b89df39c585d9be30\",\"email\":\"barbie@tysadesigns.com\",\"brokerUserId\":\"41522135174\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:tysadesigns\",\"userId\":\"d0e5da1e73794d17ab7effeb4a3f7a5b\",\"email\":\"barbie@tysadesigns.com\",\"brokerUserId\":\"41522135174\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:vannabeltgelv\",\"userId\":\"55844fb66e60402b80fb3d84d34c5a8a\",\"email\":\"julio.correa@vannabelt.com\",\"brokerUserId\":\"102568907\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:vannabeltgelv\",\"userId\":\"a4071858a3234bc4919aefb54fccf4d2\",\"email\":\"julio.correa@vannabelt.com\",\"brokerUserId\":\"102568907\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:vita-grace\",\"userId\":\"10086c0cc7d8495fa09621ba44063cce\",\"email\":\"whistl@vitagrace.co.uk\",\"brokerUserId\":\"42326851681\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:vita-grace\",\"userId\":\"6cf64fc0244c449d92e65f4846e25a75\",\"email\":\"whistl@vitagrace.co.uk\",\"brokerUserId\":\"42326851681\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:w-shaper\",\"userId\":\"2a52c84079634a0bae7fafa3bd15385d\",\"email\":\"ceozeki@gmail.com\",\"brokerUserId\":\"41243181104\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:w-shaper\",\"userId\":\"c25469e1b21945e18b7d69e0af92bb44\",\"email\":\"shapepalacestore@gmail.com\",\"brokerUserId\":\"41243181104\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:washless\",\"userId\":\"2f1226f4ea1042d887e67e929c59b3b8\",\"email\":\"kaiofv@gmail.com\",\"brokerUserId\":\"28158853190\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:washless\",\"userId\":\"e3cb570c06a0406fbd150c2b22ba0ff7\",\"email\":\"renan@visto.bio\",\"brokerUserId\":\"28158853190\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:yukitest201903\",\"userId\":\"2c5e428dca8b4bd68964741280bf706d\",\"email\":\"jh.wang@aftership.com\",\"brokerUserId\":\"39795720240\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-automizely-messages:yukitest201903\",\"userId\":\"51975b46718146ab8194d0e205fc117d\",\"email\":\"apps@aftership.com\",\"brokerUserId\":\"39795720240\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-dropshipping:aavaswim-europe\",\"userId\":\"002ae58810ac4334a13d15b997647e3c\",\"email\":\"werkstudenten@stoyo.io\",\"brokerUserId\":\"59148927133\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-dropshipping:aavaswim-europe\",\"userId\":\"25f87e46bb70458286a92f03e81ddd6d\",\"email\":\"werkstudenten@stoyo.io\",\"brokerUserId\":\"59148927133\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-dropshipping:alayathelabel\",\"userId\":\"bd2a56a5f23b4e668d68fc6be56829c0\",\"email\":\"priyasharma@stage3.co\",\"brokerUserId\":\"60597436573\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-dropshipping:alayathelabel\",\"userId\":\"f0f143f498f644cea64bc6a60e12d15d\",\"email\":\"priyasharma@stage3.co\",\"brokerUserId\":\"60597436573\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-dropshipping:cervicalcloud\",\"userId\":\"14f6e9c6656940b6959c13cfd5f65a9b\",\"email\":\"apps@aftership.com\",\"brokerUserId\":\"61443375255\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-dropshipping:cervicalcloud\",\"userId\":\"2e44c192fbdd4761907ab292524b1f76\",\"email\":\"apps@aftership.com\",\"brokerUserId\":\"61443375255\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-dropshipping:despi-usa\",\"userId\":\"787c01960f7941318d9ec001cf90b685\",\"email\":\"gallapas@gmail.com\",\"brokerUserId\":\"9776726080\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-dropshipping:despi-usa\",\"userId\":\"cbef83e22f05499caa1ec25704c4bf20\",\"email\":\"gallapas@gmail.com\",\"brokerUserId\":\"9776726080\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-dropshipping:giniartwshop\",\"userId\":\"445b3d58a1044579b9a257b677c4648a\",\"email\":\"kfenlon@fashionata.com.au\",\"brokerUserId\":\"60142452902\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-dropshipping:giniartwshop\",\"userId\":\"b69ca8a7a5eb4ec89f107fdadd86d54e\",\"email\":\"kfenlon@fashionata.com.au\",\"brokerUserId\":\"60142452902\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-dropshipping:gloryfire-us\",\"userId\":\"26046e2088a54d91a123afc13259d020\",\"email\":\"38525840@qq.com\",\"brokerUserId\":\"57925140633\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-dropshipping:gloryfire-us\",\"userId\":\"8de6187ff6b844579bfa131903829e3a\",\"email\":\"38525840@qq.com\",\"brokerUserId\":\"57925140633\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-dropshipping:herbaworks-com-my\",\"userId\":\"bc4afa4b6f8c4059841af5aa686a158e\",\"email\":\"herbaworksonline@gmail.com\",\"brokerUserId\":\"38690816088\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-dropshipping:herbaworks-com-my\",\"userId\":\"c582f61f0e4b4e78b5600075f73e1926\",\"email\":\"herbaworksonline@gmail.com\",\"brokerUserId\":\"38690816088\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-dropshipping:salt-and-lace-intimates\",\"userId\":\"1b29a69404654ecdb68b15764fd97687\",\"email\":\"glyselerio@gmail.com\",\"brokerUserId\":\"42467950689\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-dropshipping:salt-and-lace-intimates\",\"userId\":\"a0ae09dd3bd041c09eaee8dd7d0c7d66\",\"email\":\"glyselerio@gmail.com\",\"brokerUserId\":\"42467950689\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-dropshipping:signifyme\",\"userId\":\"0f4f90662e2543dd99ad3a1c976caf0d\",\"email\":\"qjackson@brandsthatdare.com\",\"brokerUserId\":\"59660697768\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-dropshipping:signifyme\",\"userId\":\"c38f58c262bc411ea688d181f475cdff\",\"email\":\"qjackson@brandsthatdare.com\",\"brokerUserId\":\"59660697768\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-dropshipping:skar-audio\",\"userId\":\"0dd7108a2d884465bcbee7c065015859\",\"email\":\"anthony@skaraudio.com\",\"brokerUserId\":\"42107207727\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-dropshipping:skar-audio\",\"userId\":\"f4479e6b96f947828be4014172c50b73\",\"email\":\"anthony@skaraudio.com\",\"brokerUserId\":\"42107207727\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-dropshipping:smets-store\",\"userId\":\"e8be5f7b504748539a549941e09c4a4e\",\"email\":\"alimou.barry@smets.lu\",\"brokerUserId\":\"41281552495\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-dropshipping:smets-store\",\"userId\":\"f94e99c9ab5b47fbaee805f073b563cb\",\"email\":\"alimou.barry@smets.lu\",\"brokerUserId\":\"41281552495\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-dropshipping:tryrecoop\",\"userId\":\"158468d7b1b24c669fc032ba9828a9f0\",\"email\":\"jill@socialpopcreative.com\",\"brokerUserId\":\"40253620260\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-dropshipping:tryrecoop\",\"userId\":\"e7be45e59ee64b0b87bacf721a6e776c\",\"email\":\"jill@socialpopcreative.com\",\"brokerUserId\":\"40253620260\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-dropshipping:watchco2dev\",\"userId\":\"1a65298bec294866a4957034378c9e7e\",\"email\":\"bricemasters@gmail.com\",\"brokerUserId\":\"40658632806\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-dropshipping:watchco2dev\",\"userId\":\"e62712770fff411ea267612c1310cd53\",\"email\":\"bricemasters@gmail.com\",\"brokerUserId\":\"40658632806\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:alayathelabel\",\"userId\":\"bd2a56a5f23b4e668d68fc6be56829c0\",\"email\":\"priyasharma@stage3.co\",\"brokerUserId\":\"60597436573\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:alayathelabel\",\"userId\":\"f0f143f498f644cea64bc6a60e12d15d\",\"email\":\"priyasharma@stage3.co\",\"brokerUserId\":\"60597436573\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:art-of-dp\",\"userId\":\"6dc0c0d975ee4425aeba8329d5d71ee2\",\"email\":\"support@ecommercegroup.ltd\",\"brokerUserId\":\"52613382279\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:art-of-dp\",\"userId\":\"d85e47a698244c2bbcc0d26fa692d740\",\"email\":\"support@ecommercegroup.ltd\",\"brokerUserId\":\"52613382279\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:bebeandme\",\"userId\":\"bddd77c79cc6484e8492192f42b80711\",\"email\":\"hello@bebeandme.co.uk\",\"brokerUserId\":\"8225292336\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:bebeandme\",\"userId\":\"f05f4a08475c485cbca3a9fc70da5abb\",\"email\":\"hello@bebeandme.co.uk\",\"brokerUserId\":\"8225292336\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:beed-speed\",\"userId\":\"c6e5819592394797b61564b579c68ab8\",\"email\":\"india2@beedspeed.com\",\"brokerUserId\":\"40970682411\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:beed-speed\",\"userId\":\"ca5dd4bf207241debf9a796c9846750e\",\"email\":\"india2@beedspeed.com\",\"brokerUserId\":\"40970682411\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:bloomonmelrose\",\"userId\":\"0646494f004b4fe9a7a77713f9cb21bc\",\"email\":\"rejane@bloomonmelrose.com\",\"brokerUserId\":\"52814023\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:bloomonmelrose\",\"userId\":\"548e8f19da54466e8635e7e1e4ca5728\",\"email\":\"rejane@bloomonmelrose.com\",\"brokerUserId\":\"52814023\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:blunbow\",\"userId\":\"0f57958e31bb44509447a52bc78b85e0\",\"email\":\"bruno.navatta@gmail.com\",\"brokerUserId\":\"42340974676\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:blunbow\",\"userId\":\"24ed7c7202f64197a91a711d6bae5457\",\"email\":\"bruno.navatta@gmail.com\",\"brokerUserId\":\"42340974676\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:cervicalcloud\",\"userId\":\"14f6e9c6656940b6959c13cfd5f65a9b\",\"email\":\"apps@aftership.com\",\"brokerUserId\":\"61443375255\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:cervicalcloud\",\"userId\":\"2e44c192fbdd4761907ab292524b1f76\",\"email\":\"apps@aftership.com\",\"brokerUserId\":\"61443375255\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:chillboys\",\"userId\":\"07320527c46e4d34a67802f38741389e\",\"email\":\"julie@chillboys.com\",\"brokerUserId\":\"57326698655\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:chillboys\",\"userId\":\"2e77510da6e84af4aee01ba2bb2ba58e\",\"email\":\"julie@chillboys.com\",\"brokerUserId\":\"57326698655\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:chopperandotis\",\"userId\":\"8934a7259b784b98954d593fb24d71bf\",\"email\":\"jungshan@chopperandotis.com\",\"brokerUserId\":\"412352526\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:chopperandotis\",\"userId\":\"c747b7a20c8248f48ffd3e74f6c4a00e\",\"email\":\"jungshan@chopperandotis.com\",\"brokerUserId\":\"412352526\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:despi-usa\",\"userId\":\"787c01960f7941318d9ec001cf90b685\",\"email\":\"gallapas@gmail.com\",\"brokerUserId\":\"9776726080\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:despi-usa\",\"userId\":\"cbef83e22f05499caa1ec25704c4bf20\",\"email\":\"gallapas@gmail.com\",\"brokerUserId\":\"9776726080\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:emoiemoi-test\",\"userId\":\"c26f24778dd74f57b6cc93eef672b94a\",\"email\":\"victor.couturier@colorz.fr\",\"brokerUserId\":\"54519726125\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:emoiemoi-test\",\"userId\":\"d8181f688c0c4d76a5838fb9b10c83a2\",\"email\":\"victor.couturier@colorz.fr\",\"brokerUserId\":\"54519726125\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:fait-par-une-maman\",\"userId\":\"8b5c6199d6404c708c3b8b38edf57ac8\",\"email\":\"boutique@faitparunemaman.ca\",\"brokerUserId\":\"41895854152\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:fait-par-une-maman\",\"userId\":\"e48c53108e184279a22495545ca17b01\",\"email\":\"boutique@faitparunemaman.ca\",\"brokerUserId\":\"41895854152\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:furbabycouture\",\"userId\":\"0ebebe3911f74d429869372483dd6f41\",\"email\":\"contact@furbabycouture.com\",\"brokerUserId\":\"112996876\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:furbabycouture\",\"userId\":\"a3a5d67c3552420994ffa748ed393230\",\"email\":\"contact@furbabycouture.com\",\"brokerUserId\":\"112996876\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:giniartwshop\",\"userId\":\"445b3d58a1044579b9a257b677c4648a\",\"email\":\"kfenlon@fashionata.com.au\",\"brokerUserId\":\"60142452902\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:giniartwshop\",\"userId\":\"b69ca8a7a5eb4ec89f107fdadd86d54e\",\"email\":\"kfenlon@fashionata.com.au\",\"brokerUserId\":\"60142452902\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:golden-wolfe\",\"userId\":\"50c0a0367f2441ee8c675076ba343b52\",\"email\":\"cody@nakedwolfe.com\",\"brokerUserId\":\"54626503\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:golden-wolfe\",\"userId\":\"72c6588331dd47559dd255b4c3f0e48a\",\"email\":\"cody@nakedwolfe.com\",\"brokerUserId\":\"54626503\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:hand-in-pocket\",\"userId\":\"6e948b8f56c14771a98f5ce0da953727\",\"email\":\"n.blochinger@yahoo.com\",\"brokerUserId\":\"39350632515\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:hand-in-pocket\",\"userId\":\"a3f531d952fa472795aed95dffa7911e\",\"email\":\"n.blochinger@yahoo.com\",\"brokerUserId\":\"39350632515\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:heissen-store\",\"userId\":\"709b4dc977f64b3a9997f2a024b9c8c5\",\"email\":\"contacto@estuyo.com.mx\",\"brokerUserId\":\"40967274574\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:heissen-store\",\"userId\":\"809495d4c6924d4d937be0729e71b353\",\"email\":\"alexisg.estuyomx@gmail.com\",\"brokerUserId\":\"40967274574\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:kettleandfire\",\"userId\":\"8f8d2d20135c4917b7e83fbe0f95b919\",\"email\":\"niccolo@bonebroths.com\",\"brokerUserId\":\"22878191733\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:kettleandfire\",\"userId\":\"b5a4ce682fba46b2af4c8be73e9858a2\",\"email\":\"niccolo@bonebroths.com\",\"brokerUserId\":\"22878191733\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:kiravans\",\"userId\":\"11d800583f884f588939ea0f004e6aee\",\"email\":\"robert@kiravans.co.uk\",\"brokerUserId\":\"38429818933\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:kiravans\",\"userId\":\"b9a38f2766834ed8a30975d698c52e95\",\"email\":\"robert@kiravans.co.uk\",\"brokerUserId\":\"38429818933\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:knock-pods\",\"userId\":\"49bb36719fb34f55853131c36c8586e6\",\"email\":\"support@knockpods.com\",\"brokerUserId\":\"40433647727\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:knock-pods\",\"userId\":\"b0bf83d522ea47b9bac7b745bbabcc22\",\"email\":\"support@knockpods.com\",\"brokerUserId\":\"40433647727\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:la-relaxed\",\"userId\":\"577c498a6b964ca28e1640743bd7dd34\",\"email\":\"jesse@larelaxed.com\",\"brokerUserId\":\"41328902237\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:la-relaxed\",\"userId\":\"974c7f41651d49eeb692e2587bbf9888\",\"email\":\"jesse@larelaxed.com\",\"brokerUserId\":\"41328902237\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:layla-collection\",\"userId\":\"12782998067a44eb93df89539d209dfb\",\"email\":\"lielaaraj@gmail.com\",\"brokerUserId\":\"56834654369\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:layla-collection\",\"userId\":\"a3472bd107c94e14a913904d7c632947\",\"email\":\"lielaaraj@gmail.com\",\"brokerUserId\":\"56834654369\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:lens-emporia\",\"userId\":\"050eb07cc7a144fa92ddb4f042c22c52\",\"email\":\"accounts@lensemporia.com\",\"brokerUserId\":\"121567059\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:lens-emporia\",\"userId\":\"0e3a631af05b43f6a3084db5c3f0e1c2\",\"email\":\"accounts@lensemporia.com\",\"brokerUserId\":\"121567059\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:maison-modulare\",\"userId\":\"30d15f7b7ffa425a8095fc93a195ff6f\",\"email\":\"info@modulare.us\",\"brokerUserId\":\"49506975881\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:maison-modulare\",\"userId\":\"bbe8668fa1334f90bf1a681d6d591899\",\"email\":\"info@modulare.us\",\"brokerUserId\":\"49506975881\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:makobi-jeans-usa\",\"userId\":\"12f44486ff434aa0a6375b23973c191a\",\"email\":\"aby@makobiusa.com\",\"brokerUserId\":\"42447667299\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:makobi-jeans-usa\",\"userId\":\"8f24030f09284995b5ccbbf687e583e2\",\"email\":\"aby@makobiusa.com\",\"brokerUserId\":\"42447667299\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:outland-denim-australia\",\"userId\":\"6bcd75975fb54f88b8bdc8ef56c84f2a\",\"email\":\"accounts@outlanddenim.com\",\"brokerUserId\":\"36231086159\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:outland-denim-australia\",\"userId\":\"c9c0d589786b45dca676ce772b941eb0\",\"email\":\"accounts@outlanddenim.com\",\"brokerUserId\":\"36231086159\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:poupette-st-barth\",\"userId\":\"b054eb4f80e84a229898dda2740964a8\",\"email\":\"editorial@poupettestbarth.com\",\"brokerUserId\":\"6554157\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:poupette-st-barth\",\"userId\":\"ccdf67827a0045018c0810dc80df12fd\",\"email\":\"editorial@poupettestbarth.com\",\"brokerUserId\":\"6554157\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:salt-and-lace-intimates\",\"userId\":\"1b29a69404654ecdb68b15764fd97687\",\"email\":\"glyselerio@gmail.com\",\"brokerUserId\":\"42467950689\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:salt-and-lace-intimates\",\"userId\":\"a0ae09dd3bd041c09eaee8dd7d0c7d66\",\"email\":\"glyselerio@gmail.com\",\"brokerUserId\":\"42467950689\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:skar-audio\",\"userId\":\"0dd7108a2d884465bcbee7c065015859\",\"email\":\"anthony@skaraudio.com\",\"brokerUserId\":\"42107207727\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:skar-audio\",\"userId\":\"f4479e6b96f947828be4014172c50b73\",\"email\":\"anthony@skaraudio.com\",\"brokerUserId\":\"42107207727\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:smets-store\",\"userId\":\"e8be5f7b504748539a549941e09c4a4e\",\"email\":\"alimou.barry@smets.lu\",\"brokerUserId\":\"41281552495\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:smets-store\",\"userId\":\"f94e99c9ab5b47fbaee805f073b563cb\",\"email\":\"alimou.barry@smets.lu\",\"brokerUserId\":\"41281552495\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:taf-mexico\",\"userId\":\"6511c2e7dbf14e90ba6c3af765b0c079\",\"email\":\"ana.ibarra@posadas.com\",\"brokerUserId\":\"52479066244\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:taf-mexico\",\"userId\":\"78b2c3a3581741f68c031fcc23845d9b\",\"email\":\"ana.ibarra@posadas.com\",\"brokerUserId\":\"52479066244\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:touchartist\",\"userId\":\"45e63e0e61b84105ba8b696514d3d835\",\"email\":\"jewelhouse02@gmail.com\",\"brokerUserId\":\"45191168131\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:touchartist\",\"userId\":\"c81de0d2f6cd4910ae84c01ae21aedef\",\"email\":\"jewelhouse02@gmail.com\",\"brokerUserId\":\"45191168131\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:trump-rack\",\"userId\":\"1a0c890cdece464bb9a56a008c38452a\",\"email\":\"ptg.czarinasamson@gmail.com\",\"brokerUserId\":\"40782331947\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:trump-rack\",\"userId\":\"8d7788af7e82468194bc37aedc402a07\",\"email\":\"ptg.czarinasamson@gmail.com\",\"brokerUserId\":\"40782331947\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:tryrecoop\",\"userId\":\"158468d7b1b24c669fc032ba9828a9f0\",\"email\":\"jill@socialpopcreative.com\",\"brokerUserId\":\"40253620260\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:tryrecoop\",\"userId\":\"e7be45e59ee64b0b87bacf721a6e776c\",\"email\":\"jill@socialpopcreative.com\",\"brokerUserId\":\"40253620260\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:tysadesigns\",\"userId\":\"26512f17d03f4b2b89df39c585d9be30\",\"email\":\"barbie@tysadesigns.com\",\"brokerUserId\":\"41522135174\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:tysadesigns\",\"userId\":\"d0e5da1e73794d17ab7effeb4a3f7a5b\",\"email\":\"barbie@tysadesigns.com\",\"brokerUserId\":\"41522135174\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:vakkerlighting\",\"userId\":\"018de814dd38460989e56b9580f860f1\",\"email\":\"kay@pinlighting.com\",\"brokerUserId\":\"49342972042\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:vakkerlighting\",\"userId\":\"f7c6d6e6ff304e9faaf1818ad40bbdff\",\"email\":\"kay@pinlighting.com\",\"brokerUserId\":\"49342972042\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:vannabeltgelv\",\"userId\":\"55844fb66e60402b80fb3d84d34c5a8a\",\"email\":\"julio.correa@vannabelt.com\",\"brokerUserId\":\"102568907\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:vannabeltgelv\",\"userId\":\"a4071858a3234bc4919aefb54fccf4d2\",\"email\":\"julio.correa@vannabelt.com\",\"brokerUserId\":\"102568907\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:vita-grace\",\"userId\":\"10086c0cc7d8495fa09621ba44063cce\",\"email\":\"whistl@vitagrace.co.uk\",\"brokerUserId\":\"42326851681\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-postmen:vita-grace\",\"userId\":\"6cf64fc0244c449d92e65f4846e25a75\",\"email\":\"whistl@vitagrace.co.uk\",\"brokerUserId\":\"42326851681\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-returnscenter:a-la-ensueno\",\"userId\":\"4ae2164342fe4ce5b77e9e9fddea2870\",\"email\":\"storeadmin@alaensueno.com\",\"brokerUserId\":\"28245262414\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-returnscenter:a-la-ensueno\",\"userId\":\"ac8b45af4cb644f2a327649fa82a4af6\",\"email\":\"storeadmin@trendzhop.com\",\"brokerUserId\":\"28245262414\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-returnscenter:a-plus-store-hamburg\",\"userId\":\"8b9b6e4f47ef45e0991db99a937c7b0a\",\"email\":\"jaap@aplusstore.com\",\"brokerUserId\":\"26992410701\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-returnscenter:a-plus-store-hamburg\",\"userId\":\"b795651b7c1f45d2a29547f123bcc8dc\",\"email\":\"jaap@allikestore.com\",\"brokerUserId\":\"26992410701\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-returnscenter:all-things-small\",\"userId\":\"4478f3e700154fa08e66c11f39fc77f5\",\"email\":\"tokyosteve1@gmail.com\",\"brokerUserId\":\"105495494\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-returnscenter:all-things-small\",\"userId\":\"b94c95d479b14489b9c31024a2780a6c\",\"email\":\"littlecuriositys@gmail.com\",\"brokerUserId\":\"105495494\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-returnscenter:art-of-dp\",\"userId\":\"6dc0c0d975ee4425aeba8329d5d71ee2\",\"email\":\"support@ecommercegroup.ltd\",\"brokerUserId\":\"52613382279\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-returnscenter:art-of-dp\",\"userId\":\"d85e47a698244c2bbcc0d26fa692d740\",\"email\":\"support@ecommercegroup.ltd\",\"brokerUserId\":\"52613382279\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-returnscenter:barcode-kwt\",\"userId\":\"251f10a1e97b4ba4b4acc10e6cf689bb\",\"email\":\"elitesouk@hotmail.com\",\"brokerUserId\":\"30177263662\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-returnscenter:barcode-kwt\",\"userId\":\"793b62d7f19544aa8b6458422e6537ce\",\"email\":\"barcode.kwt@hotmail.com\",\"brokerUserId\":\"30177263662\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-returnscenter:blunbow\",\"userId\":\"0f57958e31bb44509447a52bc78b85e0\",\"email\":\"bruno.navatta@gmail.com\",\"brokerUserId\":\"42340974676\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-returnscenter:blunbow\",\"userId\":\"24ed7c7202f64197a91a711d6bae5457\",\"email\":\"bruno.navatta@gmail.com\",\"brokerUserId\":\"42340974676\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-returnscenter:cervicalcloud\",\"userId\":\"14f6e9c6656940b6959c13cfd5f65a9b\",\"email\":\"apps@aftership.com\",\"brokerUserId\":\"61443375255\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-returnscenter:cervicalcloud\",\"userId\":\"2e44c192fbdd4761907ab292524b1f76\",\"email\":\"apps@aftership.com\",\"brokerUserId\":\"61443375255\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-returnscenter:chopperandotis\",\"userId\":\"8934a7259b784b98954d593fb24d71bf\",\"email\":\"jungshan@chopperandotis.com\",\"brokerUserId\":\"412352526\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-returnscenter:chopperandotis\",\"userId\":\"c747b7a20c8248f48ffd3e74f6c4a00e\",\"email\":\"jungshan@chopperandotis.com\",\"brokerUserId\":\"412352526\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-returnscenter:elepanta\",\"userId\":\"e73d34874cc34a99987f448bab949080\",\"email\":\"ricardohra@live.com\",\"brokerUserId\":\"49773740169\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-returnscenter:elepanta\",\"userId\":\"ee18292fba8d43b28a350301773282dc\",\"email\":\"info@elepanta.com\",\"brokerUserId\":\"49773740169\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-returnscenter:empire-performance-au\",\"userId\":\"4d7ff314313c4d0db8a554e70f4fc9fb\",\"email\":\"shopify@ppdperformance.com.au\",\"brokerUserId\":\"2628354075\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-returnscenter:empire-performance-au\",\"userId\":\"e588ee5f0d7447c7aa056224067f1f83\",\"email\":\"shopify@empireperformance.com.au\",\"brokerUserId\":\"2628354075\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-returnscenter:gaoming-test-multiple-currency\",\"userId\":\"0b3413c6ea484ddca52c4d4affc08274\",\"email\":\"yj.ma+staging@aftership.com\",\"brokerUserId\":\"48600318091\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-returnscenter:gaoming-test-multiple-currency\",\"userId\":\"ad5ab6bbf5aa4a62b69bf51d24014a64\",\"email\":\"m.gao@aftership.com\",\"brokerUserId\":\"48600318091\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-returnscenter:heissen-store\",\"userId\":\"709b4dc977f64b3a9997f2a024b9c8c5\",\"email\":\"contacto@estuyo.com.mx\",\"brokerUserId\":\"40967274574\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-returnscenter:heissen-store\",\"userId\":\"809495d4c6924d4d937be0729e71b353\",\"email\":\"alexisg.estuyomx@gmail.com\",\"brokerUserId\":\"40967274574\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-returnscenter:infinite-evolution-art\",\"userId\":\"8fc2ef888d7248a6bc37f5065505f87b\",\"email\":\"info@infiniteevolutionart.com\",\"brokerUserId\":\"50095652908\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-returnscenter:infinite-evolution-art\",\"userId\":\"d7f161f061174152bd3670332cd00e14\",\"email\":\"kev@kevenpimentel.com\",\"brokerUserId\":\"50095652908\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-returnscenter:jardim-das-ofertas\",\"userId\":\"34be4cf786674b858e6182424874eb72\",\"email\":\"ntsolucoesdigitais@gmail.com\",\"brokerUserId\":\"51289096251\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-returnscenter:jardim-das-ofertas\",\"userId\":\"fa950c1ebde949e1866ef25422f55dfe\",\"email\":\"ntsolucoesdigitais@gmail.com\",\"brokerUserId\":\"51289096251\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-returnscenter:jiraiya-the-gallant\",\"userId\":\"8e1c84d79e2c49ff966c45253bdd3053\",\"email\":\"muhammedjafri1996@gmail.com\",\"brokerUserId\":\"40918057075\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-returnscenter:jiraiya-the-gallant\",\"userId\":\"f9ffe00745084a85bcc548c555148bb0\",\"email\":\"jiraiyathegallant01@gmail.com\",\"brokerUserId\":\"40918057075\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-returnscenter:kaitekiz\",\"userId\":\"2dfcd05676ce4d1286b48084655212a6\",\"email\":\"austinbradelis@gmail.com\",\"brokerUserId\":\"41230073936\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-returnscenter:kaitekiz\",\"userId\":\"cbc126fdb33641b586da3777d20bc7b0\",\"email\":\"austinbradelis@gmail.com\",\"brokerUserId\":\"41230073936\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-returnscenter:kettleandfire\",\"userId\":\"8f8d2d20135c4917b7e83fbe0f95b919\",\"email\":\"niccolo@bonebroths.com\",\"brokerUserId\":\"22878191733\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-returnscenter:kettleandfire\",\"userId\":\"b5a4ce682fba46b2af4c8be73e9858a2\",\"email\":\"niccolo@bonebroths.com\",\"brokerUserId\":\"22878191733\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-returnscenter:lens-emporia\",\"userId\":\"050eb07cc7a144fa92ddb4f042c22c52\",\"email\":\"accounts@lensemporia.com\",\"brokerUserId\":\"121567059\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-returnscenter:lens-emporia\",\"userId\":\"0e3a631af05b43f6a3084db5c3f0e1c2\",\"email\":\"accounts@lensemporia.com\",\"brokerUserId\":\"121567059\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-returnscenter:maison-modulare\",\"userId\":\"30d15f7b7ffa425a8095fc93a195ff6f\",\"email\":\"info@modulare.us\",\"brokerUserId\":\"49506975881\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-returnscenter:maison-modulare\",\"userId\":\"bbe8668fa1334f90bf1a681d6d591899\",\"email\":\"info@modulare.us\",\"brokerUserId\":\"49506975881\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-returnscenter:monomat\",\"userId\":\"09b2c9e86b464dfd822cd53e10bcd0d2\",\"email\":\"bkoh@outlook.com\",\"brokerUserId\":\"38492078189\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-returnscenter:monomat\",\"userId\":\"6012151ff8224c41a79940432f648077\",\"email\":\"bkoh@outlook.com\",\"brokerUserId\":\"38492078189\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-returnscenter:myal-store\",\"userId\":\"a8e37c8c645c4b918e4f2c2048d01418\",\"email\":\"asdyes2020@outlook.com\",\"brokerUserId\":\"40924545111\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-returnscenter:myal-store\",\"userId\":\"b2a755dfb3d04fe4bd8d417587503375\",\"email\":\"maxdealdirect@gmail.com\",\"brokerUserId\":\"40924545111\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-returnscenter:outland-denim-australia\",\"userId\":\"6bcd75975fb54f88b8bdc8ef56c84f2a\",\"email\":\"accounts@outlanddenim.com\",\"brokerUserId\":\"36231086159\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-returnscenter:outland-denim-australia\",\"userId\":\"c9c0d589786b45dca676ce772b941eb0\",\"email\":\"accounts@outlanddenim.com\",\"brokerUserId\":\"36231086159\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-returnscenter:qayrawancaravan\",\"userId\":\"7764e6e973c54ed6bb018bd914ada5a7\",\"email\":\"ali@qayrawan.co\",\"brokerUserId\":\"1174437916\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-returnscenter:qayrawancaravan\",\"userId\":\"acdd34758df54b948ce09539a8d39df9\",\"email\":\"abensaad5@gmail.com\",\"brokerUserId\":\"1174437916\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-returnscenter:touchartist\",\"userId\":\"45e63e0e61b84105ba8b696514d3d835\",\"email\":\"jewelhouse02@gmail.com\",\"brokerUserId\":\"45191168131\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-returnscenter:touchartist\",\"userId\":\"c81de0d2f6cd4910ae84c01ae21aedef\",\"email\":\"jewelhouse02@gmail.com\",\"brokerUserId\":\"45191168131\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-returnscenter:trump-rack\",\"userId\":\"1a0c890cdece464bb9a56a008c38452a\",\"email\":\"ptg.czarinasamson@gmail.com\",\"brokerUserId\":\"40782331947\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-returnscenter:trump-rack\",\"userId\":\"8d7788af7e82468194bc37aedc402a07\",\"email\":\"ptg.czarinasamson@gmail.com\",\"brokerUserId\":\"40782331947\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-returnscenter:vakkerlighting\",\"userId\":\"018de814dd38460989e56b9580f860f1\",\"email\":\"kay@pinlighting.com\",\"brokerUserId\":\"49342972042\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-returnscenter:vakkerlighting\",\"userId\":\"f7c6d6e6ff304e9faaf1818ad40bbdff\",\"email\":\"kay@pinlighting.com\",\"brokerUserId\":\"49342972042\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-returnscenter:wall-wrenn\",\"userId\":\"a23a2c9b283a4bbcacb44e3d64ea22b1\",\"email\":\"ian.c.pu@gmail.com\",\"brokerUserId\":\"49456906373\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-returnscenter:wall-wrenn\",\"userId\":\"a995b59d1fa54d66a4046525fe4b8531\",\"email\":\"ian.c.pu@gmail.com\",\"brokerUserId\":\"49456906373\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-returnscenter:znooly\",\"userId\":\"7a9c8f5830e64d75b79a006e1a4e33dc\",\"email\":\"viashop.no@gmail.com\",\"brokerUserId\":\"41103327314\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify-returnscenter:znooly\",\"userId\":\"93e8e7dffdc64d3286b5a8ddd61202ec\",\"email\":\"beautikkcosmetics@gmail.com\",\"brokerUserId\":\"41103327314\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:active-entrepreneur\",\"userId\":\"209f5969bbd148ddafb16f53d4f49d86\",\"email\":\"julie.galloway@yahoo.com\",\"brokerUserId\":\"10496573487\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:active-entrepreneur\",\"userId\":\"8b8adf6b36c14dcca350e8d258694136\",\"email\":\"julie@theactiveentrepreneur.com\",\"brokerUserId\":\"10496573487\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:alayathelabel\",\"userId\":\"bd2a56a5f23b4e668d68fc6be56829c0\",\"email\":\"priyasharma@stage3.co\",\"brokerUserId\":\"60597436573\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:alayathelabel\",\"userId\":\"f0f143f498f644cea64bc6a60e12d15d\",\"email\":\"priyasharma@stage3.co\",\"brokerUserId\":\"60597436573\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:angiestoychest\",\"userId\":\"66089f1d474d4041adf8524b968a3544\",\"email\":\"angiestreasurechests@gmail.com\",\"brokerUserId\":\"30314201217\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:angiestoychest\",\"userId\":\"807e589db9574229b57fbf972d6cedb6\",\"email\":\"krisstar6@gmail.com\",\"brokerUserId\":\"30314201217\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:aviriska-fit\",\"userId\":\"10219dac479e41fb90e279f07d7e2c98\",\"email\":\"menamarkdown@gmail.com\",\"brokerUserId\":\"54518186135\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:aviriska-fit\",\"userId\":\"52fba4bd022c40d5ab402a33fb4aca17\",\"email\":\"aviriskafit@gmail.com\",\"brokerUserId\":\"54518186135\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:barketau\",\"userId\":\"55c722b167f941f88ded45d35d3c8871\",\"email\":\"hello@barket.com.au\",\"brokerUserId\":\"29614899300\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:barketau\",\"userId\":\"c3a94058b4ff448199695cd782e555fe\",\"email\":\"hello@barket.com.au\",\"brokerUserId\":\"29614899300\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:bebeandme\",\"userId\":\"bddd77c79cc6484e8492192f42b80711\",\"email\":\"hello@bebeandme.co.uk\",\"brokerUserId\":\"8225292336\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:bebeandme\",\"userId\":\"f05f4a08475c485cbca3a9fc70da5abb\",\"email\":\"hello@bebeandme.co.uk\",\"brokerUserId\":\"8225292336\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:beed-speed\",\"userId\":\"c6e5819592394797b61564b579c68ab8\",\"email\":\"india2@beedspeed.com\",\"brokerUserId\":\"40970682411\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:beed-speed\",\"userId\":\"ca5dd4bf207241debf9a796c9846750e\",\"email\":\"india2@beedspeed.com\",\"brokerUserId\":\"40970682411\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:bloomon-boutique\",\"userId\":\"40716f120e344374ba52412da70d7db4\",\"email\":\"bi-accounts@bloomon.nl\",\"brokerUserId\":\"40631107658\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:bloomon-boutique\",\"userId\":\"b1d4be8664f146d6bb2b6995e985c390\",\"email\":\"andrei.panait@bloomon.nl\",\"brokerUserId\":\"40631107658\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:bloomonmelrose\",\"userId\":\"0646494f004b4fe9a7a77713f9cb21bc\",\"email\":\"rejane@bloomonmelrose.com\",\"brokerUserId\":\"52814023\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:bloomonmelrose\",\"userId\":\"548e8f19da54466e8635e7e1e4ca5728\",\"email\":\"rejane@bloomonmelrose.com\",\"brokerUserId\":\"52814023\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:blunbow\",\"userId\":\"0f57958e31bb44509447a52bc78b85e0\",\"email\":\"bruno.navatta@gmail.com\",\"brokerUserId\":\"42340974676\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:blunbow\",\"userId\":\"24ed7c7202f64197a91a711d6bae5457\",\"email\":\"bruno.navatta@gmail.com\",\"brokerUserId\":\"42340974676\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:blxnt\",\"userId\":\"17f1981e106841a7ae1986fdc83fc57d\",\"email\":\"bluntcases1@gmail.com\",\"brokerUserId\":\"41362260067\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:blxnt\",\"userId\":\"3d0498605a0d409e83d1ea353d79ebd4\",\"email\":\"thebluntcompany@gmail.com\",\"brokerUserId\":\"41362260067\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:breakthru-resistance\",\"userId\":\"8a4e755ddfdf400f9c8071f1ffabc7fe\",\"email\":\"ajcovington@breakthruresistance.com\",\"brokerUserId\":\"51417841709\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:breakthru-resistance\",\"userId\":\"acd3f6c649c34c07bc80e2ec1ab00004\",\"email\":\"acovingtonbsn@outlook.com\",\"brokerUserId\":\"51417841709\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:centre-avenue\",\"userId\":\"e6c3253c132a46768d66ba4a6066a3a8\",\"email\":\"huzaifaibt@gmail.com\",\"brokerUserId\":\"47984541741\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:centre-avenue\",\"userId\":\"f6043d62261a44868cdcc4a429602c03\",\"email\":\"cakedleggings@gmail.com\",\"brokerUserId\":\"47984541741\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:chillboys\",\"userId\":\"07320527c46e4d34a67802f38741389e\",\"email\":\"julie@chillboys.com\",\"brokerUserId\":\"57326698655\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:chillboys\",\"userId\":\"2e77510da6e84af4aee01ba2bb2ba58e\",\"email\":\"julie@chillboys.com\",\"brokerUserId\":\"57326698655\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:christian-3d\",\"userId\":\"64651c9662ad4a16a343f676f62f37ed\",\"email\":\"btgroup.dung@gmail.com\",\"brokerUserId\":\"41362980939\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:christian-3d\",\"userId\":\"f00746032b1f4acf9ece76f96010b6f5\",\"email\":\"btgroup.shopifyacc@gmail.com\",\"brokerUserId\":\"41362980939\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:corafit\",\"userId\":\"2a4d68ed769944a1a7c16f82830b737e\",\"email\":\"polmingowork@gmail.com\",\"brokerUserId\":\"40382365778\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:corafit\",\"userId\":\"e2441bde0b8343e2a78070c267835055\",\"email\":\"escorafit@gmail.com\",\"brokerUserId\":\"40382365778\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:daisy-newborns\",\"userId\":\"acb2d04e080f4a5986799cc0133fec38\",\"email\":\"daisynewborns@gmail.com\",\"brokerUserId\":\"51609567368\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:daisy-newborns\",\"userId\":\"e57e6db67b5b43878130070cfa434027\",\"email\":\"cubanlinkco@gmail.com\",\"brokerUserId\":\"51609567368\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:despi-usa\",\"userId\":\"787c01960f7941318d9ec001cf90b685\",\"email\":\"gallapas@gmail.com\",\"brokerUserId\":\"9776726080\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:despi-usa\",\"userId\":\"cbef83e22f05499caa1ec25704c4bf20\",\"email\":\"gallapas@gmail.com\",\"brokerUserId\":\"9776726080\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:direct-dropship\",\"userId\":\"b0d33934644b4adf9bfe29cd154c1bfc\",\"email\":\"directdropshipuk@gmail.com\",\"brokerUserId\":\"51986563212\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:direct-dropship\",\"userId\":\"c9cfa5e8590141c4b110d531e1391a8b\",\"email\":\"directdropshipuk@gmail.com\",\"brokerUserId\":\"51986563212\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:ecomtrials1\",\"userId\":\"785e968d5e6440a2bba3e8b1a86ee771\",\"email\":\"elegantewearcustomers@gmail.com\",\"brokerUserId\":\"41023012898\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:ecomtrials1\",\"userId\":\"f92404592eda4b2083a63336ba8e9b0e\",\"email\":\"elegantewearcustomers@gmail.com\",\"brokerUserId\":\"41023012898\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:emoiemoi-test\",\"userId\":\"c26f24778dd74f57b6cc93eef672b94a\",\"email\":\"victor.couturier@colorz.fr\",\"brokerUserId\":\"54519726125\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:emoiemoi-test\",\"userId\":\"d8181f688c0c4d76a5838fb9b10c83a2\",\"email\":\"victor.couturier@colorz.fr\",\"brokerUserId\":\"54519726125\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:enjoy-picks\",\"userId\":\"14b5c1178c8342918c2d28534d817860\",\"email\":\"admin@enjoypicks.com\",\"brokerUserId\":\"10299080756\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:enjoy-picks\",\"userId\":\"530b444cf44c4b369ffc22331bc4875c\",\"email\":\"admin@enjoypicks.com\",\"brokerUserId\":\"10299080756\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:fait-par-une-maman\",\"userId\":\"8b5c6199d6404c708c3b8b38edf57ac8\",\"email\":\"boutique@faitparunemaman.ca\",\"brokerUserId\":\"41895854152\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:fait-par-une-maman\",\"userId\":\"e48c53108e184279a22495545ca17b01\",\"email\":\"boutique@faitparunemaman.ca\",\"brokerUserId\":\"41895854152\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:furbabycouture\",\"userId\":\"0ebebe3911f74d429869372483dd6f41\",\"email\":\"contact@furbabycouture.com\",\"brokerUserId\":\"112996876\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:furbabycouture\",\"userId\":\"a3a5d67c3552420994ffa748ed393230\",\"email\":\"contact@furbabycouture.com\",\"brokerUserId\":\"112996876\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:giniartwshop\",\"userId\":\"445b3d58a1044579b9a257b677c4648a\",\"email\":\"kfenlon@fashionata.com.au\",\"brokerUserId\":\"60142452902\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:giniartwshop\",\"userId\":\"b69ca8a7a5eb4ec89f107fdadd86d54e\",\"email\":\"kfenlon@fashionata.com.au\",\"brokerUserId\":\"60142452902\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:golden-wolfe\",\"userId\":\"50c0a0367f2441ee8c675076ba343b52\",\"email\":\"cody@nakedwolfe.com\",\"brokerUserId\":\"54626503\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:golden-wolfe\",\"userId\":\"72c6588331dd47559dd255b4c3f0e48a\",\"email\":\"cody@nakedwolfe.com\",\"brokerUserId\":\"54626503\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:goodcap\",\"userId\":\"188aea9b5c6c4cc0967f5efd477cf7cd\",\"email\":\"boxbeautes@gmail.com\",\"brokerUserId\":\"51531579529\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:goodcap\",\"userId\":\"7ed2308fef094b53997789cc23d33981\",\"email\":\"packageboxfrance@gmail.com\",\"brokerUserId\":\"51531579529\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:hand-in-pocket\",\"userId\":\"6e948b8f56c14771a98f5ce0da953727\",\"email\":\"n.blochinger@yahoo.com\",\"brokerUserId\":\"39350632515\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:hand-in-pocket\",\"userId\":\"a3f531d952fa472795aed95dffa7911e\",\"email\":\"n.blochinger@yahoo.com\",\"brokerUserId\":\"39350632515\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:iconictip\",\"userId\":\"4bb0d139c4c642deb944652a2cee3460\",\"email\":\"pro.yannis@outlook.fr\",\"brokerUserId\":\"27875311756\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:iconictip\",\"userId\":\"7424fe1a952e4cc5a7cf90f5d7aa61b8\",\"email\":\"pro.yannis@outlook.fr\",\"brokerUserId\":\"27875311756\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:imbclothing\",\"userId\":\"4b40f76b4e494dc88e51acaecaa4d603\",\"email\":\"gmmerancio@gmail.com\",\"brokerUserId\":\"41563717737\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:imbclothing\",\"userId\":\"bade14b7bde9469fb05021e42c0a64ef\",\"email\":\"support@imbclothing.com\",\"brokerUserId\":\"41563717737\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:imperial-motion-dev\",\"userId\":\"1ea14057cc4d407db876f5b2ec9b10e9\",\"email\":\"anthony@anthony-morgan.com\",\"brokerUserId\":\"992870414\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:imperial-motion-dev\",\"userId\":\"d1e8f5205a8b42d29cab3104be33ea11\",\"email\":\"achadmorgan@gmail.com\",\"brokerUserId\":\"992870414\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:jardim-das-ofertas\",\"userId\":\"34be4cf786674b858e6182424874eb72\",\"email\":\"ntsolucoesdigitais@gmail.com\",\"brokerUserId\":\"51289096251\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:jardim-das-ofertas\",\"userId\":\"fa950c1ebde949e1866ef25422f55dfe\",\"email\":\"ntsolucoesdigitais@gmail.com\",\"brokerUserId\":\"51289096251\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:kaitekiz\",\"userId\":\"2dfcd05676ce4d1286b48084655212a6\",\"email\":\"austinbradelis@gmail.com\",\"brokerUserId\":\"41230073936\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:kaitekiz\",\"userId\":\"cbc126fdb33641b586da3777d20bc7b0\",\"email\":\"austinbradelis@gmail.com\",\"brokerUserId\":\"41230073936\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:kalo-projector\",\"userId\":\"4ac634332bf04e5989edd67beb541730\",\"email\":\"kaloprojector@gmail.com\",\"brokerUserId\":\"40577335359\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:kalo-projector\",\"userId\":\"70fd43f5b7aa4072be80f62b59989221\",\"email\":\"cadashopcommerce@gmail.com\",\"brokerUserId\":\"40577335359\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:la-relaxed\",\"userId\":\"577c498a6b964ca28e1640743bd7dd34\",\"email\":\"jesse@larelaxed.com\",\"brokerUserId\":\"41328902237\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:la-relaxed\",\"userId\":\"974c7f41651d49eeb692e2587bbf9888\",\"email\":\"jesse@larelaxed.com\",\"brokerUserId\":\"41328902237\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:lainary\",\"userId\":\"2870deae071943c78bdf6d5969bd07d0\",\"email\":\"lightbluangel99@gmail.com\",\"brokerUserId\":\"54378102941\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:lainary\",\"userId\":\"8467bcbb1c254977821719563d77ea0c\",\"email\":\"andrewmarche99@gmail.com\",\"brokerUserId\":\"54378102941\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:layla-collection\",\"userId\":\"12782998067a44eb93df89539d209dfb\",\"email\":\"lielaaraj@gmail.com\",\"brokerUserId\":\"56834654369\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:layla-collection\",\"userId\":\"a3472bd107c94e14a913904d7c632947\",\"email\":\"lielaaraj@gmail.com\",\"brokerUserId\":\"56834654369\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:makobi-jeans-usa\",\"userId\":\"12f44486ff434aa0a6375b23973c191a\",\"email\":\"aby@makobiusa.com\",\"brokerUserId\":\"42447667299\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:makobi-jeans-usa\",\"userId\":\"8f24030f09284995b5ccbbf687e583e2\",\"email\":\"aby@makobiusa.com\",\"brokerUserId\":\"42447667299\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:mao1250\",\"userId\":\"345300522c33425a82bf5b2f9d3b5665\",\"email\":\"ch.mao+1250@aftership.com\",\"brokerUserId\":\"41169354833\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:mao1250\",\"userId\":\"8f685ce776694b47891e7cd7525ceb1d\",\"email\":\"ch.mao+1250@aftership.com\",\"brokerUserId\":\"41169354833\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:massimomilleidee\",\"userId\":\"1585e088486942738666c59ca806b43d\",\"email\":\"massimo@milleideemarket.it\",\"brokerUserId\":\"40103116858\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:massimomilleidee\",\"userId\":\"b69fec485c2a4084bb6774388c4f622c\",\"email\":\"massimomilleidee@yahoo.com\",\"brokerUserId\":\"40103116858\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:megastore608\",\"userId\":\"7bcbf8b6afb64694a2d148e193e41b86\",\"email\":\"philippbusiness630@web.de\",\"brokerUserId\":\"52091584571\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:megastore608\",\"userId\":\"c4ed6c70c49c4c97b83dde6c47a0fd22\",\"email\":\"business.philippnotzon@gmail.com\",\"brokerUserId\":\"52091584571\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:mostly-shades\",\"userId\":\"7e5c8f80d38549b7bb48ace3207e7fad\",\"email\":\"aherre24@bargainbaitbox.com\",\"brokerUserId\":\"24047648866\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:mostly-shades\",\"userId\":\"e299f4404a6c411d99c94be6d39f8a10\",\"email\":\"aherre24@mostlyshades.com\",\"brokerUserId\":\"24047648866\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:onlypugstuff\",\"userId\":\"948ae772480d4eeaa29f32a0cd70bc08\",\"email\":\"info@onlypugstuff.com\",\"brokerUserId\":\"1944092741\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:onlypugstuff\",\"userId\":\"cc482a9522e74b69b5f7cc52649f6655\",\"email\":\"info@onlypugstuff.com\",\"brokerUserId\":\"1944092741\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:organicthenewbeauty\",\"userId\":\"3dee128d8e6447ac9cb46472f7844920\",\"email\":\"mvogt@thecleanbeauty.co\",\"brokerUserId\":\"30093082753\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:organicthenewbeauty\",\"userId\":\"695c7a4d426f4d03b1bd7941e2a76677\",\"email\":\"theclinicalbeauty@gmail.com\",\"brokerUserId\":\"30093082753\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:regine-tweezers\",\"userId\":\"01ceae6e0a7647229c86bc5e6e6788d9\",\"email\":\"skrane@skrane.com\",\"brokerUserId\":\"28647719021\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:regine-tweezers\",\"userId\":\"6959d33f27044da6b9fbf900cce5a960\",\"email\":\"skrane@skrane.com\",\"brokerUserId\":\"28647719021\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:rustanscom\",\"userId\":\"97b0aba9264d40a0965db7bd321f0edd\",\"email\":\"krgalvia@rustans.com.ph\",\"brokerUserId\":\"26754777186\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:rustanscom\",\"userId\":\"cfef75902f974408afa01c60356fcf6f\",\"email\":\"krgalvia@rustans.com\",\"brokerUserId\":\"26754777186\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:salt-and-lace-intimates\",\"userId\":\"1b29a69404654ecdb68b15764fd97687\",\"email\":\"glyselerio@gmail.com\",\"brokerUserId\":\"42467950689\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:salt-and-lace-intimates\",\"userId\":\"a0ae09dd3bd041c09eaee8dd7d0c7d66\",\"email\":\"glyselerio@gmail.com\",\"brokerUserId\":\"42467950689\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:shoplucidbeautycosmetics\",\"userId\":\"15850867e5c54c019267deadbd7833a4\",\"email\":\"lucidbeautycosmetics@gmail.com\",\"brokerUserId\":\"41773924436\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:shoplucidbeautycosmetics\",\"userId\":\"3d27fcd77fad45dda46b05491d99fa14\",\"email\":\"aishachase66@gmail.com\",\"brokerUserId\":\"41773924436\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:skar-audio\",\"userId\":\"0dd7108a2d884465bcbee7c065015859\",\"email\":\"anthony@skaraudio.com\",\"brokerUserId\":\"42107207727\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:skar-audio\",\"userId\":\"f4479e6b96f947828be4014172c50b73\",\"email\":\"anthony@skaraudio.com\",\"brokerUserId\":\"42107207727\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:sleutel\",\"userId\":\"74fe4097611947d78e220faf1800b8e4\",\"email\":\"kippenmeester@hotmail.com\",\"brokerUserId\":\"40688746607\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:sleutel\",\"userId\":\"9c985f413b534745b21a204b3c62824e\",\"email\":\"matthijsvertelman@hotmail.com\",\"brokerUserId\":\"40688746607\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:smets-store\",\"userId\":\"e8be5f7b504748539a549941e09c4a4e\",\"email\":\"alimou.barry@smets.lu\",\"brokerUserId\":\"41281552495\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:smets-store\",\"userId\":\"f94e99c9ab5b47fbaee805f073b563cb\",\"email\":\"alimou.barry@smets.lu\",\"brokerUserId\":\"41281552495\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:surf-pepper-tots\",\"userId\":\"48471eb193bf4f7d8798fd3ceb7dd3d6\",\"email\":\"ngewqr@gmail.com\",\"brokerUserId\":\"54552658071\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:surf-pepper-tots\",\"userId\":\"6a062f123a5e48c0b1d3699cfabaa37c\",\"email\":\"ngewqr@gmail.com\",\"brokerUserId\":\"54552658071\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:tatashopbelgium\",\"userId\":\"6d41de0c44094426b2ae8b965f93fa83\",\"email\":\"becharged10@gmail.com\",\"brokerUserId\":\"27046936640\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:tatashopbelgium\",\"userId\":\"c32aa509e14048b5b4869d900c75fbae\",\"email\":\"tamara.delfosse@live.be\",\"brokerUserId\":\"27046936640\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:testforchat\",\"userId\":\"0face0c0035f4529a51bbc41d0bc0cc2\",\"email\":\"sy.li+0421@aftership.com\",\"brokerUserId\":\"40163573875\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:testforchat\",\"userId\":\"ecb85c77ce194fcfabd519a94e69f079\",\"email\":\"sy.li@aftership.com\",\"brokerUserId\":\"40163573875\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:the-frankie-shop-eu\",\"userId\":\"2ae617ca1ce04166a03a562f0ac1bdfb\",\"email\":\"gaelle@thefrankieshop.com\",\"brokerUserId\":\"41925312565\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:the-frankie-shop-eu\",\"userId\":\"87f090ad0c41434ebf5ba010383ed76a\",\"email\":\"gaelle@thefrankieshop.com\",\"brokerUserId\":\"41925312565\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:the-green-key\",\"userId\":\"740e8fed6b4043e98f8d4c521c04fced\",\"email\":\"grace.g.woodward@gmail.com\",\"brokerUserId\":\"54228189344\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:the-green-key\",\"userId\":\"9082542fa38244229de588f6c2817c16\",\"email\":\"thegreenkeystore@gmail.com\",\"brokerUserId\":\"54228189344\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:the-od\",\"userId\":\"0455e5688aee44b5b3d5d51f2b77a1dc\",\"email\":\"support@sunset-swimwear.com\",\"brokerUserId\":\"40276885592\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:the-od\",\"userId\":\"5fd4670fde3a4bb987831e09fb42dd22\",\"email\":\"support@evercycles.com\",\"brokerUserId\":\"40276885592\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:tuvals\",\"userId\":\"2ffc5151a3f0417d887a5f49c82d6648\",\"email\":\"assaftuv@gmail.com\",\"brokerUserId\":\"27593310306\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:tuvals\",\"userId\":\"ede8e0cf565e4d6a846f21579b7f3eda\",\"email\":\"italianlly.ecomm@gmail.com\",\"brokerUserId\":\"27593310306\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:tysadesigns\",\"userId\":\"26512f17d03f4b2b89df39c585d9be30\",\"email\":\"barbie@tysadesigns.com\",\"brokerUserId\":\"41522135174\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:tysadesigns\",\"userId\":\"d0e5da1e73794d17ab7effeb4a3f7a5b\",\"email\":\"barbie@tysadesigns.com\",\"brokerUserId\":\"41522135174\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:ultra-green-coffee-asia\",\"userId\":\"a8cdf9229c774e2c8c6fcbc564a603e5\",\"email\":\"roylanminano06@gmail.com\",\"brokerUserId\":\"41076752448\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:ultra-green-coffee-asia\",\"userId\":\"dd5ed7d8fe6e459da68bd1a07807ff37\",\"email\":\"royztv06@gmail.com\",\"brokerUserId\":\"41076752448\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:uvwandstore\",\"userId\":\"841667b1c95b42b6a5bea6f3c119a4dc\",\"email\":\"support@germalightwand.com\",\"brokerUserId\":\"40557543499\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:uvwandstore\",\"userId\":\"da2745c1fbb240e48f84859731de4555\",\"email\":\"info@eazidrone.com\",\"brokerUserId\":\"40557543499\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:vannabeltgelv\",\"userId\":\"55844fb66e60402b80fb3d84d34c5a8a\",\"email\":\"julio.correa@vannabelt.com\",\"brokerUserId\":\"102568907\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:vannabeltgelv\",\"userId\":\"a4071858a3234bc4919aefb54fccf4d2\",\"email\":\"julio.correa@vannabelt.com\",\"brokerUserId\":\"102568907\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:vita-grace\",\"userId\":\"10086c0cc7d8495fa09621ba44063cce\",\"email\":\"whistl@vitagrace.co.uk\",\"brokerUserId\":\"42326851681\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:vita-grace\",\"userId\":\"6cf64fc0244c449d92e65f4846e25a75\",\"email\":\"whistl@vitagrace.co.uk\",\"brokerUserId\":\"42326851681\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:woofwhite\",\"userId\":\"14df1fd653eb4a208ea76b9af19baabc\",\"email\":\"woofwhite.shop@gmail.com\",\"brokerUserId\":\"49337532556\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:woofwhite\",\"userId\":\"5cddbb7af1b941ceacae2fceb2ed3627\",\"email\":\"woofwhite.shop@gmail.com\",\"brokerUserId\":\"49337532556\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:znooly\",\"userId\":\"7a9c8f5830e64d75b79a006e1a4e33dc\",\"email\":\"viashop.no@gmail.com\",\"brokerUserId\":\"41103327314\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"shopify:znooly\",\"userId\":\"93e8e7dffdc64d3286b5a8ddd61202ec\",\"email\":\"beautikkcosmetics@gmail.com\",\"brokerUserId\":\"41103327314\",\"realm\":\"business\"},\n" +
                "{\"providerId\":\"google\",\"userId\":\"001e58b5cd5f4e308a2b3475f3476e4f\",\"email\":\"business@zeroforfive.com\",\"brokerUserId\":\"102166296194109667969\",\"realm\":\"business\"}\n" +
                "]";
        String accountJson = "[\n" +
                "    {\n" +
                "        \"email\":\"business@zeroforfive.com\",\n" +
                "        \"account_id\":\"001e58b5cd5f4e308a2b3475f3476e4f\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"bizdev@stoyo.io\",\n" +
                "        \"account_id\":\"002ae58810ac4334a13d15b997647e3c\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"shopsforgood@gmail.com\",\n" +
                "        \"account_id\":\"006f1780a8ec41a69d811b7a70727cac\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"aura@mooielight.com\",\n" +
                "        \"account_id\":\"018de814dd38460989e56b9580f860f1\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"skrane@skrane.com\",\n" +
                "        \"account_id\":\"01ceae6e0a7647229c86bc5e6e6788d9\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"support@sunset-swimwear.com\",\n" +
                "        \"account_id\":\"0455e5688aee44b5b3d5d51f2b77a1dc\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"hello@lensemporia.com\",\n" +
                "        \"account_id\":\"050eb07cc7a144fa92ddb4f042c22c52\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"andrew@bloomonmelrose.com\",\n" +
                "        \"account_id\":\"0646494f004b4fe9a7a77713f9cb21bc\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"kmattson@m2kbrands.com\",\n" +
                "        \"account_id\":\"07320527c46e4d34a67802f38741389e\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"bkoh@outlook.com\",\n" +
                "        \"account_id\":\"09b2c9e86b464dfd822cd53e10bcd0d2\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"yj.ma+staging@aftership.com\",\n" +
                "        \"account_id\":\"0b3413c6ea484ddca52c4d4affc08274\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"lloydk@skaraudio.com\",\n" +
                "        \"account_id\":\"0dd7108a2d884465bcbee7c065015859\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"accounts@lensemporia.com\",\n" +
                "        \"account_id\":\"0e3a631af05b43f6a3084db5c3f0e1c2\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"contact@furbabycouture.com\",\n" +
                "        \"account_id\":\"0ebebe3911f74d429869372483dd6f41\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"qntnjcksn@gmail.com\",\n" +
                "        \"account_id\":\"0f4f90662e2543dd99ad3a1c976caf0d\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"bruno.navatta@gmail.com\",\n" +
                "        \"account_id\":\"0f57958e31bb44509447a52bc78b85e0\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"sy.li+0716@aftership.com\",\n" +
                "        \"account_id\":\"0face0c0035f4529a51bbc41d0bc0cc2\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"hello@vitagrace.co.uk\",\n" +
                "        \"account_id\":\"10086c0cc7d8495fa09621ba44063cce\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"menamarkdown@gmail.com\",\n" +
                "        \"account_id\":\"10219dac479e41fb90e279f07d7e2c98\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"robert@kiravans.co.uk\",\n" +
                "        \"account_id\":\"11d800583f884f588939ea0f004e6aee\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"lielaaraj@gmail.com\",\n" +
                "        \"account_id\":\"12782998067a44eb93df89539d209dfb\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"aby@makobiusa.com\",\n" +
                "        \"account_id\":\"12f44486ff434aa0a6375b23973c191a\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"admin@mycaffeinelab.com\",\n" +
                "        \"account_id\":\"14b5c1178c8342918c2d28534d817860\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"woofwhite.shop@gmail.com\",\n" +
                "        \"account_id\":\"14df1fd653eb4a208ea76b9af19baabc\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"manish.mittal@aftership.com\",\n" +
                "        \"account_id\":\"14f6e9c6656940b6959c13cfd5f65a9b\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"jill@socialpopcreative.com\",\n" +
                "        \"account_id\":\"158468d7b1b24c669fc032ba9828a9f0\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"lucidbeautycosmetics@gmail.com\",\n" +
                "        \"account_id\":\"15850867e5c54c019267deadbd7833a4\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"massimo@milleideemarket.it\",\n" +
                "        \"account_id\":\"1585e088486942738666c59ca806b43d\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"bluntcases1@gmail.com\",\n" +
                "        \"account_id\":\"17f1981e106841a7ae1986fdc83fc57d\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"boxbeautes@gmail.com\",\n" +
                "        \"account_id\":\"188aea9b5c6c4cc0967f5efd477cf7cd\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"ptg.czarinasamson@gmail.com\",\n" +
                "        \"account_id\":\"1a0c890cdece464bb9a56a008c38452a\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"offerhero@gmail.com\",\n" +
                "        \"account_id\":\"1a65298bec294866a4957034378c9e7e\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"glyselerio@gmail.com\",\n" +
                "        \"account_id\":\"1b29a69404654ecdb68b15764fd97687\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"anthony@anthony-morgan.com\",\n" +
                "        \"account_id\":\"1ea14057cc4d407db876f5b2ec9b10e9\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"julie.galloway@yahoo.com\",\n" +
                "        \"account_id\":\"209f5969bbd148ddafb16f53d4f49d86\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"hola@blunbowstore.com\",\n" +
                "        \"account_id\":\"24ed7c7202f64197a91a711d6bae5457\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"elitesouk@hotmail.com\",\n" +
                "        \"account_id\":\"251f10a1e97b4ba4b4acc10e6cf689bb\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"werkstudenten@stoyo.io\",\n" +
                "        \"account_id\":\"25f87e46bb70458286a92f03e81ddd6d\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"38525840@qq.com\",\n" +
                "        \"account_id\":\"26046e2088a54d91a123afc13259d020\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"barbie@tysadesigns.com\",\n" +
                "        \"account_id\":\"26512f17d03f4b2b89df39c585d9be30\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"deleted_1577290866_happykevinmeyer@gmail.com\",\n" +
                "        \"account_id\":\"28589c992c4e4979911e7b5afbe1f664\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"lightbluangel99@gmail.com\",\n" +
                "        \"account_id\":\"2870deae071943c78bdf6d5969bd07d0\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"polmingowork@gmail.com\",\n" +
                "        \"account_id\":\"2a4d68ed769944a1a7c16f82830b737e\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"ceozeki@gmail.com\",\n" +
                "        \"account_id\":\"2a52c84079634a0bae7fafa3bd15385d\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"gaelle@thefrankieshop.com\",\n" +
                "        \"account_id\":\"2ae617ca1ce04166a03a562f0ac1bdfb\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"jh.wang@aftership.com\",\n" +
                "        \"account_id\":\"2c5e428dca8b4bd68964741280bf706d\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"shockshockads@gmail.com\",\n" +
                "        \"account_id\":\"2dfcd05676ce4d1286b48084655212a6\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"farouk.naimi@gmail.com\",\n" +
                "        \"account_id\":\"2e44c192fbdd4761907ab292524b1f76\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"julie@chillboys.com\",\n" +
                "        \"account_id\":\"2e77510da6e84af4aee01ba2bb2ba58e\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"kaiofv@gmail.com\",\n" +
                "        \"account_id\":\"2f1226f4ea1042d887e67e929c59b3b8\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"assaftuv@gmail.com\",\n" +
                "        \"account_id\":\"2ffc5151a3f0417d887a5f49c82d6648\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"harsha.thomas@gmail.com\",\n" +
                "        \"account_id\":\"302ce092fd48405d9c47ef99582506be\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"info@modulare.us\",\n" +
                "        \"account_id\":\"30d15f7b7ffa425a8095fc93a195ff6f\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"scoreszone@hotmail.com\",\n" +
                "        \"account_id\":\"3436228c4f644c35bdcbd11d4331254e\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"ch.mao+1250@aftership.com\",\n" +
                "        \"account_id\":\"345300522c33425a82bf5b2f9d3b5665\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"ofertasemdia@zohomail.com\",\n" +
                "        \"account_id\":\"34be4cf786674b858e6182424874eb72\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"patriciamagova123@gmail.com\",\n" +
                "        \"account_id\":\"39adb3efcfed456cb27557cdee8dc98a\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"thebluntcompany@gmail.com\",\n" +
                "        \"account_id\":\"3d0498605a0d409e83d1ea353d79ebd4\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"aishachase66@gmail.com\",\n" +
                "        \"account_id\":\"3d27fcd77fad45dda46b05491d99fa14\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"jennahm.park@gmail.com\",\n" +
                "        \"account_id\":\"3dc9d0c051a84df59949b5ede11eff11\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"mvogt@thecleanbeauty.co\",\n" +
                "        \"account_id\":\"3dee128d8e6447ac9cb46472f7844920\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"vritika.sharma@aftership.com\",\n" +
                "        \"account_id\":\"406b6ba5056145a8957643c3a6fdbecc\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"bi-accounts@bloomon.nl\",\n" +
                "        \"account_id\":\"40716f120e344374ba52412da70d7db4\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"gschwartz@fashionata.com.au\",\n" +
                "        \"account_id\":\"445b3d58a1044579b9a257b677c4648a\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"tokyosteve1@gmail.com\",\n" +
                "        \"account_id\":\"4478f3e700154fa08e66c11f39fc77f5\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"globalecom2020@gmail.com\",\n" +
                "        \"account_id\":\"45e63e0e61b84105ba8b696514d3d835\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"mail@surfpeppertots.com\",\n" +
                "        \"account_id\":\"48471eb193bf4f7d8798fd3ceb7dd3d6\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"support@knockpods.com\",\n" +
                "        \"account_id\":\"49bb36719fb34f55853131c36c8586e6\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"kaloprojector@gmail.com\",\n" +
                "        \"account_id\":\"4ac634332bf04e5989edd67beb541730\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"support@alaensueno.com\",\n" +
                "        \"account_id\":\"4ae2164342fe4ce5b77e9e9fddea2870\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"gmmerancio@gmail.com\",\n" +
                "        \"account_id\":\"4b40f76b4e494dc88e51acaecaa4d603\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"deleted_1576095488_pro.yannis@outlook.fr\",\n" +
                "        \"account_id\":\"4bb0d139c4c642deb944652a2cee3460\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"shopify@ppdperformance.com.au\",\n" +
                "        \"account_id\":\"4d7ff314313c4d0db8a554e70f4fc9fb\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"cody@nakedwolfe.com\",\n" +
                "        \"account_id\":\"50c0a0367f2441ee8c675076ba343b52\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"apps@aftership.com\",\n" +
                "        \"account_id\":\"51975b46718146ab8194d0e205fc117d\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"aviriskafit@gmail.com\",\n" +
                "        \"account_id\":\"52fba4bd022c40d5ab402a33fb4aca17\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"admin@enjoypicks.com\",\n" +
                "        \"account_id\":\"530b444cf44c4b369ffc22331bc4875c\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"favouronuorah388@gmail.com\",\n" +
                "        \"account_id\":\"53333b70cf144514a73f1462ec256c97\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"deleted_1573608695_andrew@bluntcanada.ca\",\n" +
                "        \"account_id\":\"5408386eaf1f4bcba0b1313e0c2651d4\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"rejane@bloomonmelrose.com\",\n" +
                "        \"account_id\":\"548e8f19da54466e8635e7e1e4ca5728\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"deleted_1573795998_vritikasharma.95@gmail.com\",\n" +
                "        \"account_id\":\"55644303f73048d6afea941c72c30588\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"info@vannabelt.com\",\n" +
                "        \"account_id\":\"55844fb66e60402b80fb3d84d34c5a8a\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"hello@woofingtons.co\",\n" +
                "        \"account_id\":\"55c722b167f941f88ded45d35d3c8871\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"dana90265@gmail.com\",\n" +
                "        \"account_id\":\"577c498a6b964ca28e1640743bd7dd34\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"admin@toskadirect.com\",\n" +
                "        \"account_id\":\"5aa8a56a7e3c4690884ac652296be224\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"dogoptions.shop@gmail.com\",\n" +
                "        \"account_id\":\"5cddbb7af1b941ceacae2fceb2ed3627\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"korega_378@hotmail.com\",\n" +
                "        \"account_id\":\"5eea5ae10a2e4a36868029bf2cd41f2d\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"support@tempo-ride.com\",\n" +
                "        \"account_id\":\"5fd4670fde3a4bb987831e09fb42dd22\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"hello@creamhaus.us\",\n" +
                "        \"account_id\":\"6012151ff8224c41a79940432f648077\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"btgroup.dung@gmail.com\",\n" +
                "        \"account_id\":\"64651c9662ad4a16a343f676f62f37ed\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"adrian.gonzalez@privalia.com\",\n" +
                "        \"account_id\":\"6511c2e7dbf14e90ba6c3af765b0c079\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"angiestreasurechests@gmail.com\",\n" +
                "        \"account_id\":\"66089f1d474d4041adf8524b968a3544\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"deleted_1573153587_happyplacesuppliers@gmail.com\",\n" +
                "        \"account_id\":\"689a58c60d054fc5b021c71758ab0d19\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"info@sunglassesdirect.com\",\n" +
                "        \"account_id\":\"6959d33f27044da6b9fbf900cce5a960\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"theclinicalbeauty@gmail.com\",\n" +
                "        \"account_id\":\"695c7a4d426f4d03b1bd7941e2a76677\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"dmarsh@hatclub.com\",\n" +
                "        \"account_id\":\"69ab6ad9687e4bbfa14da7c5ea7cfd96\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"ngewqr@gmail.com\",\n" +
                "        \"account_id\":\"6a062f123a5e48c0b1d3699cfabaa37c\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"deleted_1574847761_seemaamola123@gmail.com\",\n" +
                "        \"account_id\":\"6ad9e335baf546e9bc850caf9cf69149\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"darren@outlanddenim.com\",\n" +
                "        \"account_id\":\"6bcd75975fb54f88b8bdc8ef56c84f2a\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"whistl@vitagrace.co.uk\",\n" +
                "        \"account_id\":\"6cf64fc0244c449d92e65f4846e25a75\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"becharged10@gmail.com\",\n" +
                "        \"account_id\":\"6d41de0c44094426b2ae8b965f93fa83\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"ceo@artofdiamondpainting.com\",\n" +
                "        \"account_id\":\"6dc0c0d975ee4425aeba8329d5d71ee2\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"service@handinpocket.com\",\n" +
                "        \"account_id\":\"6e948b8f56c14771a98f5ce0da953727\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"contacto@estuyo.com.mx\",\n" +
                "        \"account_id\":\"709b4dc977f64b3a9997f2a024b9c8c5\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"cadashopcommerce@gmail.com\",\n" +
                "        \"account_id\":\"70fd43f5b7aa4072be80f62b59989221\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"info@nakedwolfe.com\",\n" +
                "        \"account_id\":\"72c6588331dd47559dd255b4c3f0e48a\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"extremlysales@gmail.com\",\n" +
                "        \"account_id\":\"73abaaf09c574333a4199ecb7459a1d4\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"grace.g.woodward@gmail.com\",\n" +
                "        \"account_id\":\"740e8fed6b4043e98f8d4c521c04fced\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"pro.yannis@outlook.fr\",\n" +
                "        \"account_id\":\"7424fe1a952e4cc5a7cf90f5d7aa61b8\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"kippenmeester@hotmail.com\",\n" +
                "        \"account_id\":\"74fe4097611947d78e220faf1800b8e4\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"ali@qayrawan.co\",\n" +
                "        \"account_id\":\"7764e6e973c54ed6bb018bd914ada5a7\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"shqair275@gmail.com\",\n" +
                "        \"account_id\":\"785e968d5e6440a2bba3e8b1a86ee771\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"despina@despi.com.br\",\n" +
                "        \"account_id\":\"787c01960f7941318d9ec001cf90b685\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"ana.ibarra@posadas.com\",\n" +
                "        \"account_id\":\"78b2c3a3581741f68c031fcc23845d9b\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"barcode.kwt@hotmail.com\",\n" +
                "        \"account_id\":\"793b62d7f19544aa8b6458422e6537ce\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"viashop.no@gmail.com\",\n" +
                "        \"account_id\":\"7a9c8f5830e64d75b79a006e1a4e33dc\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"philippbusiness630@web.de\",\n" +
                "        \"account_id\":\"7bcbf8b6afb64694a2d148e193e41b86\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"aherre24@bargainbaitbox.com\",\n" +
                "        \"account_id\":\"7e5c8f80d38549b7bb48ace3207e7fad\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"packageboxfrance@gmail.com\",\n" +
                "        \"account_id\":\"7ed2308fef094b53997789cc23d33981\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"fw.he@aftership.com\",\n" +
                "        \"account_id\":\"7f2d6ce8f43d438a8a6642371463648f\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"krisstar6@gmail.com\",\n" +
                "        \"account_id\":\"807e589db9574229b57fbf972d6cedb6\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"alexisg.estuyomx@gmail.com\",\n" +
                "        \"account_id\":\"809495d4c6924d4d937be0729e71b353\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"shopwithyoupr@yahoo.com\",\n" +
                "        \"account_id\":\"823c0586119c4bc79edf920b8da89833\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"support@germalightwand.com\",\n" +
                "        \"account_id\":\"841667b1c95b42b6a5bea6f3c119a4dc\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"andrewmarche99@gmail.com\",\n" +
                "        \"account_id\":\"8467bcbb1c254977821719563d77ea0c\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"masteradmin@ec.jayagrocer.com\",\n" +
                "        \"account_id\":\"850db8ca328247df9ccb69094b5107e9\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"cassandylangs@gmail.com\",\n" +
                "        \"account_id\":\"879075fa9b3a484dad3c61c9f0aec6fc\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"parisstore@thefrankieshop.com\",\n" +
                "        \"account_id\":\"87f090ad0c41434ebf5ba010383ed76a\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"jungshanlee@gmail.com\",\n" +
                "        \"account_id\":\"8934a7259b784b98954d593fb24d71bf\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"ajcovington@breakthruresistance.com\",\n" +
                "        \"account_id\":\"8a4e755ddfdf400f9c8071f1ffabc7fe\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"annyevillemure@gmail.com\",\n" +
                "        \"account_id\":\"8b5c6199d6404c708c3b8b38edf57ac8\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"julie@theactiveentrepreneur.com\",\n" +
                "        \"account_id\":\"8b8adf6b36c14dcca350e8d258694136\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"jaap@aplusstore.com\",\n" +
                "        \"account_id\":\"8b9b6e4f47ef45e0991db99a937c7b0a\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"4mostip@gmail.com\",\n" +
                "        \"account_id\":\"8d4d45d577534d1ca7c8bec468540c7a\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"support@trumprack.com\",\n" +
                "        \"account_id\":\"8d7788af7e82468194bc37aedc402a07\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"dosthama91@gmail.com\",\n" +
                "        \"account_id\":\"8de6187ff6b844579bfa131903829e3a\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"muhammedjafri1996@gmail.com\",\n" +
                "        \"account_id\":\"8e1c84d79e2c49ff966c45253bdd3053\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"anc.knockout@gmail.com\",\n" +
                "        \"account_id\":\"8f24030f09284995b5ccbbf687e583e2\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"aftership.io@gmail.com\",\n" +
                "        \"account_id\":\"8f685ce776694b47891e7cd7525ceb1d\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"niccolo@bonebroths.com\",\n" +
                "        \"account_id\":\"8f8d2d20135c4917b7e83fbe0f95b919\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"info@infiniteevolutionart.com\",\n" +
                "        \"account_id\":\"8fc2ef888d7248a6bc37f5065505f87b\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"thegreenkeystore@gmail.com\",\n" +
                "        \"account_id\":\"9082542fa38244229de588f6c2817c16\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"ecommadmin@hatclub.com\",\n" +
                "        \"account_id\":\"90f2faf6a0c24a4bbb00248a32355555\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"jableyenda32@gmail.com\",\n" +
                "        \"account_id\":\"92d82e944d8343a98733984f74a86c86\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"beautikkcosmetics@gmail.com\",\n" +
                "        \"account_id\":\"93e8e7dffdc64d3286b5a8ddd61202ec\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"deleted_1576512604_info@onlypugstuff.com\",\n" +
                "        \"account_id\":\"948ae772480d4eeaa29f32a0cd70bc08\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"jesse@larelaxed.com\",\n" +
                "        \"account_id\":\"974c7f41651d49eeb692e2587bbf9888\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"krgalvia@rustans.com.ph\",\n" +
                "        \"account_id\":\"97b0aba9264d40a0965db7bd321f0edd\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"thetopref@gmail.com\",\n" +
                "        \"account_id\":\"980db8eaaf0c40418130fd303a927f4c\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"deleted_1575706559_business@zeroforfive.com\",\n" +
                "        \"account_id\":\"997d84f0437d49c4a24904771d269179\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"matthijsvertelman@hotmail.com\",\n" +
                "        \"account_id\":\"9c985f413b534745b21a204b3c62824e\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"deleted_1576347587_4mostip@gmail.com\",\n" +
                "        \"account_id\":\"a00e88a3280b4c298ec94ab5bfc1cea5\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"support@saltandlaceintimates.com\",\n" +
                "        \"account_id\":\"a0ae09dd3bd041c09eaee8dd7d0c7d66\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"ian@wallandwrenn.com\",\n" +
                "        \"account_id\":\"a23a2c9b283a4bbcacb44e3d64ea22b1\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"sarahshannan1996@gmail.com\",\n" +
                "        \"account_id\":\"a3472bd107c94e14a913904d7c632947\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"deleted_1577092982_thetopref@gmail.com\",\n" +
                "        \"account_id\":\"a39088146d3b4d3cb93c2b13a81330c1\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"deleted_1575309808_leshana28@gmail.com\",\n" +
                "        \"account_id\":\"a39e9d79b6504fd889016cc45712f94f\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"furbabycouture@gmail.com\",\n" +
                "        \"account_id\":\"a3a5d67c3552420994ffa748ed393230\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"n.blochinger@yahoo.com\",\n" +
                "        \"account_id\":\"a3f531d952fa472795aed95dffa7911e\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"julio.correa@vannabelt.com\",\n" +
                "        \"account_id\":\"a4071858a3234bc4919aefb54fccf4d2\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"pintsnbottles@gmail.com\",\n" +
                "        \"account_id\":\"a5ebceba4cbc4c58a34a4b2141e93528\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"eduardonbaallstar@gmail.com\",\n" +
                "        \"account_id\":\"a6c64a762e5f44d0b928705a84ff1436\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"deleted_1574272455_cassandylangs@gmail.com\",\n" +
                "        \"account_id\":\"a7e8c5f33a9d4aa19bfdb54a86a746f0\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"roylanminano06@gmail.com\",\n" +
                "        \"account_id\":\"a8cdf9229c774e2c8c6fcbc564a603e5\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"asdyes2020@outlook.com\",\n" +
                "        \"account_id\":\"a8e37c8c645c4b918e4f2c2048d01418\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"ian.c.pu@gmail.com\",\n" +
                "        \"account_id\":\"a995b59d1fa54d66a4046525fe4b8531\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"masteradmin@jayagrocer.online\",\n" +
                "        \"account_id\":\"ac7ebc91b70349ee894ef4a72cd067df\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"storeadmin@trendzhop.com\",\n" +
                "        \"account_id\":\"ac8b45af4cb644f2a327649fa82a4af6\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"retrovibesthrift@gmail.com\",\n" +
                "        \"account_id\":\"acb2d04e080f4a5986799cc0133fec38\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"acovingtonbsn@outlook.com\",\n" +
                "        \"account_id\":\"acd3f6c649c34c07bc80e2ec1ab00004\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"abensaad5@gmail.com\",\n" +
                "        \"account_id\":\"acdd34758df54b948ce09539a8d39df9\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"m.gao@aftership.com\",\n" +
                "        \"account_id\":\"ad5ab6bbf5aa4a62b69bf51d24014a64\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"cristinaperez201990@gmail.com\",\n" +
                "        \"account_id\":\"ae90d93259b4467e885ca20e0b152b52\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"geoffrey.bagot@poupettestbarth.com\",\n" +
                "        \"account_id\":\"b054eb4f80e84a229898dda2740964a8\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"admin@knockpods.com\",\n" +
                "        \"account_id\":\"b0bf83d522ea47b9bac7b745bbabcc22\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"directdropshipuk@gmail.com\",\n" +
                "        \"account_id\":\"b0d33934644b4adf9bfe29cd154c1bfc\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"andrei.panait@bloomon.nl\",\n" +
                "        \"account_id\":\"b1d4be8664f146d6bb2b6995e985c390\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"contact@mazitoo.com\",\n" +
                "        \"account_id\":\"b2a755dfb3d04fe4bd8d417587503375\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"thebeefmarketplace@gmail.com\",\n" +
                "        \"account_id\":\"b4b45b09376b4bf381a705a3cab71dd0\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"seemaamola123@gmail.com\",\n" +
                "        \"account_id\":\"b4f570a0c5e8482990d5d35e3c2cb31a\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"wilson@kettleandfire.com\",\n" +
                "        \"account_id\":\"b5a4ce682fba46b2af4c8be73e9858a2\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"kfenlon@fashionata.com.au\",\n" +
                "        \"account_id\":\"b69ca8a7a5eb4ec89f107fdadd86d54e\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"massimomilleidee@yahoo.com\",\n" +
                "        \"account_id\":\"b69fec485c2a4084bb6774388c4f622c\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"jaap@allikestore.com\",\n" +
                "        \"account_id\":\"b795651b7c1f45d2a29547f123bcc8dc\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"littlecuriositys@gmail.com\",\n" +
                "        \"account_id\":\"b94c95d479b14489b9c31024a2780a6c\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"help@kiravans.co.uk\",\n" +
                "        \"account_id\":\"b9a38f2766834ed8a30975d698c52e95\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"support@imbclothing.com\",\n" +
                "        \"account_id\":\"bade14b7bde9469fb05021e42c0a64ef\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"lieck@mac.com\",\n" +
                "        \"account_id\":\"bbe8668fa1334f90bf1a681d6d591899\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"syahidahshajahan.herbaworks@gmail.com\",\n" +
                "        \"account_id\":\"bc4afa4b6f8c4059841af5aa686a158e\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"piyush@stage3.co\",\n" +
                "        \"account_id\":\"bd2a56a5f23b4e668d68fc6be56829c0\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"hello@bebeandme.co.uk\",\n" +
                "        \"account_id\":\"bddd77c79cc6484e8492192f42b80711\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"littlejewelers1@gmail.com\",\n" +
                "        \"account_id\":\"bf3f2af25c7f4affa2d407f26089188b\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"shapepalacestore@gmail.com\",\n" +
                "        \"account_id\":\"c25469e1b21945e18b7d69e0af92bb44\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"victor.couturier@colorz.fr\",\n" +
                "        \"account_id\":\"c26f24778dd74f57b6cc93eef672b94a\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"tamara.delfosse@live.be\",\n" +
                "        \"account_id\":\"c32aa509e14048b5b4869d900c75fbae\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"qjackson@brandsthatdare.com\",\n" +
                "        \"account_id\":\"c38f58c262bc411ea688d181f475cdff\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"hello@barket.com.au\",\n" +
                "        \"account_id\":\"c3a94058b4ff448199695cd782e555fe\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"business.philippnotzon@gmail.com\",\n" +
                "        \"account_id\":\"c4ed6c70c49c4c97b83dde6c47a0fd22\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"shoponlinepr@yahoo.com\",\n" +
                "        \"account_id\":\"c4f86dddf47844b1813be3cedc9b00c5\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"herbaworksonline@gmail.com\",\n" +
                "        \"account_id\":\"c582f61f0e4b4e78b5600075f73e1926\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"india2@beedspeed.com\",\n" +
                "        \"account_id\":\"c6e5819592394797b61564b579c68ab8\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"jungshan@chopperandotis.com\",\n" +
                "        \"account_id\":\"c747b7a20c8248f48ffd3e74f6c4a00e\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"vritikasharma.95@gmail.com\",\n" +
                "        \"account_id\":\"c7fd4d0c715a45cc965855237bf1db45\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"jewelhouse02@gmail.com\",\n" +
                "        \"account_id\":\"c81de0d2f6cd4910ae84c01ae21aedef\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"accounts@outlanddenim.com\",\n" +
                "        \"account_id\":\"c9c0d589786b45dca676ce772b941eb0\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"meorganicsboutique@gmail.com\",\n" +
                "        \"account_id\":\"c9cfa5e8590141c4b110d531e1391a8b\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"sales@beedspeed.com\",\n" +
                "        \"account_id\":\"ca5dd4bf207241debf9a796c9846750e\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"austinbradelis@gmail.com\",\n" +
                "        \"account_id\":\"cbc126fdb33641b586da3777d20bc7b0\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"gallapas@gmail.com\",\n" +
                "        \"account_id\":\"cbef83e22f05499caa1ec25704c4bf20\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"info@onlypugstuff.com\",\n" +
                "        \"account_id\":\"cc482a9522e74b69b5f7cc52649f6655\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"editorial@poupettestbarth.com\",\n" +
                "        \"account_id\":\"ccdf67827a0045018c0810dc80df12fd\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"deleted_1589054482_harsha.thomas@gmail.com\",\n" +
                "        \"account_id\":\"cd1c577e376d4dad892cbe662d21cc2c\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"krgalvia@rustans.com\",\n" +
                "        \"account_id\":\"cfef75902f974408afa01c60356fcf6f\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"barbie.rae@gmail.com\",\n" +
                "        \"account_id\":\"d0e5da1e73794d17ab7effeb4a3f7a5b\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"andrew@bluntcanada.ca\",\n" +
                "        \"account_id\":\"d1a4ef42aa7749ee87df63d4c7abdda5\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"achadmorgan@gmail.com\",\n" +
                "        \"account_id\":\"d1e8f5205a8b42d29cab3104be33ea11\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"happykevinmeyer@gmail.com\",\n" +
                "        \"account_id\":\"d423fc35f21643c6b12d26985f95c256\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"kev@kevenpimentel.com\",\n" +
                "        \"account_id\":\"d7f161f061174152bd3670332cd00e14\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"david@colorz.fr\",\n" +
                "        \"account_id\":\"d8181f688c0c4d76a5838fb9b10c83a2\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"support@ecommercegroup.ltd\",\n" +
                "        \"account_id\":\"d85e47a698244c2bbcc0d26fa692d740\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"cyy1270@outlook.com\",\n" +
                "        \"account_id\":\"da245e134641472cae0cae866083ceb9\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"info@eazidrone.com\",\n" +
                "        \"account_id\":\"da2745c1fbb240e48f84859731de4555\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"royztv06@gmail.com\",\n" +
                "        \"account_id\":\"dd5ed7d8fe6e459da68bd1a07807ff37\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"dripoinfo@gmail.com\",\n" +
                "        \"account_id\":\"e2441bde0b8343e2a78070c267835055\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"aherre24@mostlyshades.com\",\n" +
                "        \"account_id\":\"e299f4404a6c411d99c94be6d39f8a10\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"doggyliciousstore@gmail.com\",\n" +
                "        \"account_id\":\"e34d34d64f1b4f1382872a83d4f9a005\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"renan@visto.bio\",\n" +
                "        \"account_id\":\"e3cb570c06a0406fbd150c2b22ba0ff7\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"boutique@faitparunemaman.ca\",\n" +
                "        \"account_id\":\"e48c53108e184279a22495545ca17b01\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"deleted_1575341587_leshana28@gmail.com\",\n" +
                "        \"account_id\":\"e49aa7c86e4a421b9ad465caa406a883\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"cubanlinkco@gmail.com\",\n" +
                "        \"account_id\":\"e57e6db67b5b43878130070cfa434027\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"shopify@empireperformance.com.au\",\n" +
                "        \"account_id\":\"e588ee5f0d7447c7aa056224067f1f83\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"bricemasters@gmail.com\",\n" +
                "        \"account_id\":\"e62712770fff411ea267612c1310cd53\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"huzaifaibt@gmail.com\",\n" +
                "        \"account_id\":\"e6c3253c132a46768d66ba4a6066a3a8\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"ricardohra@live.com\",\n" +
                "        \"account_id\":\"e73d34874cc34a99987f448bab949080\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"biz@getrecoop.com\",\n" +
                "        \"account_id\":\"e7be45e59ee64b0b87bacf721a6e776c\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"alimou.barry@smets.lu\",\n" +
                "        \"account_id\":\"e8be5f7b504748539a549941e09c4a4e\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"admin@tmbeautybar.com\",\n" +
                "        \"account_id\":\"eb7211fe1446468aa7ed9f430be5c2ff\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"sy.li@aftership.com\",\n" +
                "        \"account_id\":\"ecb85c77ce194fcfabd519a94e69f079\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"italianlly.ecomm@gmail.com\",\n" +
                "        \"account_id\":\"ede8e0cf565e4d6a846f21579b7f3eda\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"info@elepanta.com\",\n" +
                "        \"account_id\":\"ee18292fba8d43b28a350301773282dc\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"btgroup.shopifyacc@gmail.com\",\n" +
                "        \"account_id\":\"f00746032b1f4acf9ece76f96010b6f5\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"hello@anotherversion.co.uk\",\n" +
                "        \"account_id\":\"f05f4a08475c485cbca3a9fc70da5abb\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"priyasharma@stage3.co\",\n" +
                "        \"account_id\":\"f0f143f498f644cea64bc6a60e12d15d\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"extremelysales@gmail.com\",\n" +
                "        \"account_id\":\"f1ae0d21faa04ca8898a7c8bb0323d81\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"anthony@skaraudio.com\",\n" +
                "        \"account_id\":\"f4479e6b96f947828be4014172c50b73\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"urwigg@gmail.com\",\n" +
                "        \"account_id\":\"f5acd42f157d45d1a6bc3718f1eb5115\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"cakedleggings@gmail.com\",\n" +
                "        \"account_id\":\"f6043d62261a44868cdcc4a429602c03\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"kay@pinlighting.com\",\n" +
                "        \"account_id\":\"f7c6d6e6ff304e9faaf1818ad40bbdff\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"deleted_1574073900_vritika.sharma@aftership.com\",\n" +
                "        \"account_id\":\"f7c7079eb9994d108a48af8e5827e1b4\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"elegantewearcustomers@gmail.com\",\n" +
                "        \"account_id\":\"f92404592eda4b2083a63336ba8e9b0e\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"e-shop@smets.lu\",\n" +
                "        \"account_id\":\"f94e99c9ab5b47fbaee805f073b563cb\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"jiraiyathegallant01@gmail.com\",\n" +
                "        \"account_id\":\"f9ffe00745084a85bcc548c555148bb0\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"email\":\"oficial@ofertasemdia.com\",\n" +
                "        \"account_id\":\"fa950c1ebde949e1866ef25422f55dfe\"\n" +
                "    }\n" +
                "]";


        //根据 providerId + brokerUserId 创建一个对象，该对象最多有两个 broker link，每个 broker link 对应着一个 account
        // 先把 account 的 email 检查一遍，如果包含 deleted_，那么就把该 account_id 对应的 broker link删除掉
        //再检查 providerId + brokerUserId 是否只对应一个 broker link 了，如果否，则再比较哪个 broker link 的 email 跟 account email 一致，然后把不一致的给删掉
        List<BrokerLink> brokerLinkList = JSONArray.parseArray(brokerlinkJson,BrokerLink.class);
        List<Account> accountsList = JSONArray.parseArray(accountJson,Account.class);
        List<BrokerLink> needDeleteBrokerLinkList = new ArrayList<BrokerLink>();

        Map<String,Account> accountMap = new HashMap<String, Account>();
        for(Account account:accountsList){
            accountMap.put(account.getAccount_id(),account);
        }
        //遍历 broker link，把对应不上 account 的 broker link 都删掉
        List<BrokerLink> firstPassedBrokerLinkList = new ArrayList<BrokerLink>();
        for(BrokerLink brokerLink : brokerLinkList){
            Account brokerAccount = accountMap.get(brokerLink.getUserId());
            if(brokerAccount!=null){
                brokerLink.setAccountEmail(brokerAccount.getEmail());
                firstPassedBrokerLinkList.add(brokerLink);
            }else {
                needDeleteBrokerLinkList.add(brokerLink);
            }
        }
        // 遍历通过第一次校验的 broker link ，然后把对应 account email 包含 deleted_ 的删掉
        List<BrokerLink> secondPassedBrokerLinkList = new ArrayList<BrokerLink>();
        for(BrokerLink brokerLink:firstPassedBrokerLinkList){
            if(brokerLink.getAccountEmail().contains("deleted_")){
                needDeleteBrokerLinkList.add(brokerLink);
            }else {
                secondPassedBrokerLinkList.add(brokerLink);
            }
        }
        int deletedAccountCount = needDeleteBrokerLinkList.size();
        // 新增二次校验的 map, key = providerId&&brokerUserId, value = list<brokerlink>
        Map<String,List<BrokerLink>> doubleCheckMap = new HashMap<String, List<BrokerLink>>();
        for(BrokerLink brokerLink : secondPassedBrokerLinkList){
            String key = brokerLink.getProviderId()+"&&"+brokerLink.getBrokerUserId();
            if(doubleCheckMap.get(key)!=null){
                List<BrokerLink> list = doubleCheckMap.get(key);
                list.add(brokerLink);
            }else {
                List<BrokerLink> list = new ArrayList<BrokerLink>();
                list.add(brokerLink);
                doubleCheckMap.put(key,list);
            }
        }
        int needFixCount = 0;
        Iterator keySet=  doubleCheckMap.keySet().iterator();
        while (keySet.hasNext()){
            List<BrokerLink>  links = doubleCheckMap.get(keySet.next());
            // 如果走完上一轮，该 providerId+brokerUserId依然有一条以上的 broker link，那么我们就把 broker email 跟 account email 不一致的加入待删除列表
            if(links!=null&&links.size()>1){
                needFixCount++;
                Boolean hasMatchEmail = false;
                int matchCount = 0;
                for(BrokerLink brokerLink:links){
                    //先看是否有匹配的 email
                    if(brokerLink.getEmail().equalsIgnoreCase(brokerLink.getAccountEmail())){
                        hasMatchEmail = true;
                        matchCount++;
                    }
                }
                if(matchCount>1){
                    for(BrokerLink link:links){
                        System.out.println("match:"+link);
                    }
                    System.out.println();
                }
                // 如果有匹配的，则把其他 email 不相等的 broker link 给删掉
                if(hasMatchEmail){
                    for(BrokerLink brokerLink:links){
                        if(!brokerLink.getEmail().equalsIgnoreCase(brokerLink.getAccountEmail())){
                            needDeleteBrokerLinkList.add(brokerLink);
                        }
                    }
                }else {
                    //如果没有匹配的 email
                    for(BrokerLink link:links){
                        System.out.println(link);

                    }
                }
            }
        }
        System.out.println("----------------------------------------------------------");
        //最终打印需要删除的 broker link
        for(BrokerLink brokerLink:needDeleteBrokerLinkList){
            System.out.println("DELETE FROM keycloak.BROKER_LINK where USER_ID='f:6f7e6de9-411b-43d1-8c63-cbce920a7f99:"+brokerLink.getUserId()+"' AND REALM_ID='"+brokerLink.getRealm()+"' AND IDENTITY_PROVIDER='"+brokerLink.getProviderId()+"' AND BROKER_USER_ID='"+brokerLink.getBrokerUserId()+"';");
        }
        System.out.println("因为 account 被删除所以删除的 broker link 数量为:"+deletedAccountCount+"，总共删除 broker link 数量为:"+needDeleteBrokerLinkList.size()+",needFixCount:"+needFixCount);


    }
}
