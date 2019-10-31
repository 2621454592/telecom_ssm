<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
        <%@include file="../../include/header.jsp" %>
        <script type="text/javascript">
        $(document).ready(function(){
        	$("#search").click(function(){
        		var id = $("#selModules").val();
        		var name = $("#selectrolename").val();
        		location.href='${pageContext.request.contextPath}/admin/SelectAdminByConditionAction.do?selectpid='+id+"&selectrolename="+name;
        	});
        });
            //显示角色详细信息
            function showDetail(flag, a) {
                var detailDiv = a.parentNode.getElementsByTagName("div")[0];
                if (flag) {
                    detailDiv.style.display = "block";
                }
                else
                    detailDiv.style.display = "none";
            }
            //重置密码
            function resetPwd() {
                alert("请至少选择一条数据！");
                //document.getElementById("operate_result_info").style.display = "block";
            }
            //删除
            function deleteAdmin(aid) {
            	
                var r = window.confirm("确定要删除此管理员吗？");
                if(r){
                	location.href='${pageContext.request.contextPath}/admin/DeleteAdminAction.do?aid='+aid;
                }  
                var msg='${msg}';
                if(msg!=""){
                	$("#operate_result_info").append(msg);
                	 document.getElementById("operate_result_info").style.display = "block";
                }
               
            }
            //修改
            function updateAdmin(aid) {
            	location.href='${pageContext.request.contextPath}/admin/ShowUpdateAdminAction.do?aid='+aid;
			}
            
            //全选
            function selectAdmins(inputObj) {
                var inputArray = document.getElementById("datalist").getElementsByTagName("input");
                for (var i = 1; i < inputArray.length; i++) {
                    if (inputArray[i].type == "checkbox") {
                        inputArray[i].checked = inputObj.checked;
                    }
                }
            }
        </script>       
    </head>
    <body>
      <%@include file="../../include/navi.jsp" %>
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">
            <form action="" method="">
                <!--查询-->
                <div class="search_add">
                    <div>
                        模块：   
                        <select id="selModules" class="select_search" name="selectpower">
                            <option value="0">全部</option>  
                            <c:forEach items="${powerlist }" var="power">                 
                            <option value="${power.id }">${power.pname }</option> 
                            </c:forEach>                                                
                        </select>
                    </div>
                    <div>角色：<input type="text" value="" class="text_search width200" name="selectrolename" id="selectrolename"/></div>
                    <div><input type="button" value="搜索" id="search" class="btn_search" onclick="select();" /></div>
                    <input type="button" value="密码重置" class="btn_add" onclick="resetPwd();" />
                    <input type="button" value="增加" class="btn_add" onclick="location.href='${pageContext.request.contextPath}/admin/showAddAdminAction';" />
                </div>
                <!--删除和密码重置的操作提示-->
                <div id="operate_result_info" class="operate_fail">
                    <img src="../images/close.png" onclick="this.parentNode.style.display='none';" />
                    <span></span><!--密码重置失败！数据并发错误。-->
                </div> 
                <!--数据区域：用表格展示数据-->     
                <div id="data">            
                    <table id="datalist">
                        <tr>
                            <th class="th_select_all">
                                <input type="checkbox" onclick="selectAdmins(this);" />
                                <span>全选</span>
                            </th>
                            <th>管理员ID</th>
                            <th>头像</th>
                            <th>姓名</th>
                            <th>登录名</th>
                            <th>电话</th>
                            <th>电子邮件</th>
                            <th>授权日期</th>
                            <th class="width100">拥有角色</th>
                            <th></th>
                        </tr>      
                             <c:forEach items="${adminlist }" var="admin">                         
                        <tr>  
                            <td><input type="checkbox" /></td>
                            <td>${admin.id }</td>
                            <td><img alt="无" src="${pageContext.request.contextPath }${admin.aimg }"></td>
                            <td>${admin.aname }</td>
                            <td>${admin.acname }</td>
                            <td>${admin.atel }</td>
                            <td>${admin.aemail }</td>
                            <td>${admin.createTime }</td>
                            <td>${admin.RL }</td>
                            <td class="td_modi">
                                <input type="button" value="修改" class="btn_modify" onclick="updateAdmin(${admin.id})" />
                                <input type="button" value="删除" class="btn_delete" onclick="deleteAdmin(${admin.id})"/>
                            </td>                             
                        </tr>
                        </c:forEach>
                    </table>
                </div>
                <!--分页-->
                <div id="pages">
        	        <a href="#">上一页</a>
                    <a href="#" class="current_page">1</a>
                    <a href="#">2</a>
                    <a href="#">3</a>
                    <a href="#">4</a>
                    <a href="#">5</a>
                    <a href="#">下一页</a>
                </div>                    
            </form>
        </div>
        <!--主要区域结束-->
        <div id="footer">
          
        </div>
    </body>
</html>
