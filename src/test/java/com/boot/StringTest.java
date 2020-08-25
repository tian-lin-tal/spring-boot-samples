package com.boot;

/**
 * @author l.tian@aftership.com
 * @date 2020/6/19
 */
public class StringTest {
    public static void main(String[] args) {
        String preStr = "93 --- Afghanistan\n" +
                "355 --- Albania\n" +
                "213 --- Algeria\n" +
                "684 --- American Samoa\n" +
                "376 --- Andorra\n" +
                "244 --- Angola\n" +
                "809 --- Anguilla\n" +
                "268 --- Antigua\n" +
                "54 --- Argentina\n" +
                "374 --- Armenia\n" +
                "297 --- Aruba\n" +
                "247 --- Ascension Island\n" +
                "61 --- Australia\n" +
                "672 --- Australian External Territories\n" +
                "43 --- Austria\n" +
                "994 --- Azerbaijan\n" +
                "242 --- Bahamas\n" +
                "246 --- Barbados\n" +
                "973 --- Bahrain\n" +
                "880 --- Bangladesh\n" +
                "375 --- Belarus\n" +
                "32 --- Belgium\n" +
                "501 --- Belize\n" +
                "229 --- Benin\n" +
                "809 --- Bermuda\n" +
                "975 --- Bhutan\n" +
                "284 --- British Virgin Islands\n" +
                "591 --- Bolivia\n" +
                "387 --- Bosnia and Hercegovina\n" +
                "267 --- Botswana\n" +
                "55 --- Brazil\n" +
                "284 --- British V.I.\n" +
                "673 --- Brunei Darussalm\n" +
                "359 --- Bulgaria\n" +
                "226 --- Burkina Faso\n" +
                "257 --- Burundi\n" +
                "855 --- Cambodia\n" +
                "237 --- Cameroon\n" +
                "1 --- Canada\n" +
                "238 --- CapeVerde Islands\n" +
                "1 --- Caribbean Nations\n" +
                "345 --- Cayman Islands\n" +
                "238 --- Cape Verdi\n" +
                "236 --- Central African Republic\n" +
                "235 --- Chad\n" +
                "56 --- Chile\n" +
                "86 --- China (People's Republic)\n" +
                "886 --- China-Taiwan\n" +
                "57 --- Colombia\n" +
                "269 --- Comoros and Mayotte\n" +
                "242 --- Congo\n" +
                "682 --- Cook Islands\n" +
                "506 --- Costa Rica\n" +
                "385 --- Croatia\n" +
                "53 --- Cuba\n" +
                "357 --- Cyprus\n" +
                "420 --- Czech Republic\n" +
                "45 --- Denmark\n" +
                "246 --- Diego Garcia\n" +
                "767 --- Dominca\n" +
                "809 --- Dominican Republic\n" +
                "253 --- Djibouti\n" +
                "593 --- Ecuador\n" +
                "20 --- Egypt\n" +
                "503 --- El Salvador\n" +
                "240 --- Equatorial Guinea\n" +
                "291 --- Eritrea\n" +
                "372 --- Estonia\n" +
                "251 --- Ethiopia\n" +
                "500 --- Falkland Islands\n" +
                "298 --- Faroe (Faeroe) Islands (Denmark)\n" +
                "679 --- Fiji\n" +
                "358 --- Finland\n" +
                "33 --- France\n" +
                "596 --- French Antilles\n" +
                "594 --- French Guiana\n" +
                "241 --- Gabon (Gabonese Republic)\n" +
                "220 --- Gambia\n" +
                "995 --- Georgia\n" +
                "49 --- Germany\n" +
                "233 --- Ghana\n" +
                "350 --- Gibraltar\n" +
                "30 --- Greece\n" +
                "299 --- Greenland\n" +
                "473 --- Grenada/Carricou\n" +
                "671 --- Guam\n" +
                "502 --- Guatemala\n" +
                "224 --- Guinea\n" +
                "245 --- Guinea-Bissau\n" +
                "592 --- Guyana\n" +
                "509 --- Haiti\n" +
                "504 --- Honduras\n" +
                "852 --- Hong Kong\n" +
                "36 --- Hungary\n" +
                "354 --- Iceland\n" +
                "91 --- India\n" +
                "62 --- Indonesia\n" +
                "98 --- Iran\n" +
                "964 --- Iraq\n" +
                "353 --- Ireland (Irish Republic; Eire)\n" +
                "972 --- Israel\n" +
                "39 --- Italy\n" +
                "225 --- Ivory Coast (La Cote d'Ivoire)\n" +
                "876 --- Jamaica\n" +
                "81 --- Japan\n" +
                "962 --- Jordan\n" +
                "7 --- Kazakhstan\n" +
                "254 --- Kenya\n" +
                "855 --- Khmer Republic (Cambodia/Kampuchea)\n" +
                "686 --- Kiribati Republic (Gilbert Islands)\n" +
                "82 --- Korea, Republic of (South Korea)\n" +
                "850 --- Korea, People's Republic of (North Korea)\n" +
                "965 --- Kuwait\n" +
                "996 --- Kyrgyz Republic\n" +
                "371 --- Latvia\n" +
                "856 --- Laos\n" +
                "961 --- Lebanon\n" +
                "266 --- Lesotho\n" +
                "231 --- Liberia\n" +
                "370 --- Lithuania\n" +
                "218 --- Libya\n" +
                "423 --- Liechtenstein\n" +
                "352 --- Luxembourg\n" +
                "853 --- Macao\n" +
                "389 --- Macedonia\n" +
                "261 --- Madagascar\n" +
                "265 --- Malawi\n" +
                "60 --- Malaysia\n" +
                "960 --- Maldives\n" +
                "223 --- Mali\n" +
                "356 --- Malta\n" +
                "692 --- Marshall Islands\n" +
                "596 --- Martinique (French Antilles)\n" +
                "222 --- Mauritania\n" +
                "230 --- Mauritius\n" +
                "269 --- Mayolte\n" +
                "52 --- Mexico\n" +
                "691 --- Micronesia (F.S. of Polynesia)\n" +
                "373 --- Moldova\n" +
                "33 --- Monaco\n" +
                "976 --- Mongolia\n" +
                "473 --- Montserrat\n" +
                "212 --- Morocco\n" +
                "258 --- Mozambique\n" +
                "95 --- Myanmar (former Burma)\n" +
                "264 --- Namibia (former South-West Africa)\n" +
                "674 --- Nauru\n" +
                "977 --- Nepal\n" +
                "31 --- Netherlands\n" +
                "599 --- Netherlands Antilles\n" +
                "869 --- Nevis\n" +
                "687 --- New Caledonia\n" +
                "64 --- New Zealand\n" +
                "505 --- Nicaragua\n" +
                "227 --- Niger\n" +
                "234 --- Nigeria\n" +
                "683 --- Niue\n" +
                "850 --- North Korea\n" +
                "1 670 --- North Mariana Islands (Saipan)\n" +
                "47 --- Norway\n" +
                "968 --- Oman\n" +
                "92 --- Pakistan\n" +
                "680 --- Palau\n" +
                "507 --- Panama\n" +
                "675 --- Papua New Guinea\n" +
                "595 --- Paraguay\n" +
                "51 --- Peru\n" +
                "63 --- Philippines\n" +
                "48 --- Poland\n" +
                "351 --- Portugal (includes Azores)\n" +
                "1 787 --- Puerto Rico\n" +
                "974 --- Qatar\n" +
                "262 --- Reunion (France)\n" +
                "40 --- Romania\n" +
                "7 --- Russia\n" +
                "250 --- Rwanda (Rwandese Republic)\n" +
                "670 --- Saipan\n" +
                "378 --- San Marino\n" +
                "239 --- Sao Tome and Principe\n" +
                "966 --- Saudi Arabia\n" +
                "221 --- Senegal\n" +
                "381 --- Serbia and Montenegro\n" +
                "248 --- Seychelles\n" +
                "232 --- Sierra Leone\n" +
                "65 --- Singapore\n" +
                "421 --- Slovakia\n" +
                "386 --- Slovenia\n" +
                "677 --- Solomon Islands\n" +
                "252 --- Somalia\n" +
                "27 --- South Africa\n" +
                "34 --- Spain\n" +
                "94 --- Sri Lanka\n" +
                "290 --- St. Helena\n" +
                "869 --- St. Kitts/Nevis\n" +
                "508 --- St. Pierre &(et) Miquelon (France)\n" +
                "249 --- Sudan\n" +
                "597 --- Suriname\n" +
                "268 --- Swaziland\n" +
                "46 --- Sweden\n" +
                "41 --- Switzerland\n" +
                "963 --- Syrian Arab Republic (Syria)\n" +
                "689 --- Tahiti (French Polynesia)\n" +
                "886 --- Taiwan\n" +
                "7 --- Tajikistan\n" +
                "255 --- Tanzania (includes Zanzibar)\n" +
                "66 --- Thailand\n" +
                "228 --- Togo (Togolese Republic)\n" +
                "690 --- Tokelau\n" +
                "676 --- Tonga\n" +
                "1 868 --- Trinidad and Tobago\n" +
                "216 --- Tunisia\n" +
                "90 --- Turkey\n" +
                "993 --- Turkmenistan\n" +
                "688 --- Tuvalu (Ellice Islands)\n" +
                "256 --- Uganda\n" +
                "380 --- Ukraine\n" +
                "971 --- United Arab Emirates\n" +
                "44 --- United Kingdom\n" +
                "598 --- Uruguay\n" +
                "1 --- USA\n" +
                "7 --- Uzbekistan\n" +
                "678 --- Vanuatu (New Hebrides)\n" +
                "39 --- Vatican City\n" +
                "58 --- Venezuela\n" +
                "84 --- Viet Nam\n" +
                "1 340 --- Virgin Islands\n" +
                "681 --- Wallis and Futuna\n" +
                "685 --- Western Samoa\n" +
                "381 --- Yemen (People's Democratic Republic of)\n" +
                "967 --- Yemen Arab Republic (North Yemen)\n" +
                "381 --- Yugoslavia (discontinued)\n" +
                "243 --- Zaire\n" +
                "260 --- Zambia\n" +
                "263 --- Zimbabwe";

        String[] codes = preStr.split("\n");
        StringBuilder builder = new StringBuilder("{");
        for(String info:codes){
            String[] infoStr  = info.split(" --- ");
            builder.append("\"");
            builder.append(infoStr[0]);
            builder.append("\":\"");
            builder.append(infoStr[1]);
            builder.append("\",");
        }

        System.out.println(builder.toString());
    }
}
