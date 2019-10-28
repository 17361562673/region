<%--
  Created by IntelliJ IDEA.
  User: 17361562673
  Date: 2019/10/17
  Time: 12:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>联动下拉框</title>
    <script type="text/javascript">
        var xmlHttp;
        function createAjax() {
            try {
                // Firefox, Opera 8.0+, Safari
                xmlHttp = new XMLHttpRequest();
            } catch (e) {
                // Internet Explorer
                try {
                    xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
                } catch (e) {
                    try {
                        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                    } catch (e) {
                        alert("您的浏览器不支持AJAX！");
                        return false;
                    }
                }
            }
        }
        function loadArea(obj,areaType) {
            createAjax();
            var url="/region_war_exploded/loadOp";
            xmlHttp.open('post',url,true);
            xmlHttp.setRequestHeader("CONTENT-TYPE", "application/x-www-form-urlencoded");
            xmlHttp.onreadystatechange=function () {
                if (xmlHttp.readyState == 4) {
                    if (xmlHttp.status == 200) {
                        var  result=xmlHttp.responseText;
                        //将字符串重组成js可以识别的数组
                            var jsonResult=window.eval("("+result+")");
                            if (areaType=='city') {
                                var loadOpt="<option value=\"-2\">--请选择城市--</option>"
                                var loadCity=document.getElementById("city");
                                for (var i = 0; i <jsonResult.length; i++) {
                                    var re_id=jsonResult[i].re_id;
                                    var re_name=jsonResult[i].re_name;
                                    loadOpt=loadOpt+"<option value=\""+re_id+"\">"+re_name+"</option>"
                                }
                                loadCity.innerHTML=loadOpt;
                        }else if (areaType=='district') {
                                var loadOpt="<option value=\"-2\">--请选择区/县--</option>"
                                var loadCount=document.getElementById("district");
                                for (var i = 0; i <jsonResult.length; i++) {
                                    var re_id=jsonResult[i].re_id;
                                    var re_name=jsonResult[i].re_name;
                                    loadOpt=loadOpt+"<option value=\""+re_id+"\">"+re_name+"</option>"
                                }
                                loadCount.innerHTML=loadOpt;
                            }
                    }
                }
            }
            var data="pid="+obj.value;
            xmlHttp.send(data);
        }
    </script>
</head>
<body>
<table>
    <tr>
        <td>省
            <select id="province" onchange="loadArea(this,'city')">
                <option value="-2">--请选择省--</option>
                <c:forEach items="${pList}" var="p">
                    <option value="${p.re_id}">${p.re_name}</option>
                </c:forEach>
            </select>
        </td>
        <td>市
            <select id="city">

            </select>
        </td>
        <td>区/县
            <select id="district" onchange="loadArea(this,'jladgads')">

            </select>
        </td>
    </tr>
</table>
</body>
</html>
