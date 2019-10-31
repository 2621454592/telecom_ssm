<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
        <%@include file="../../include/header.jsp" %>
        <script language="javascript" type="text/javascript">
            //保存成功的提示消息
            $(function() {
				 $("#smit").click(function() {
					$(".main_form").submit();
				})
				var msg='${msg}';
				if(msg!=""){
					showResult(msg);			
				}
				
			})
            function showResult(msg) {
                showResultDiv(true,msg);
                window.setTimeout("showResultDiv(false,'');", 3000);
            }
            function showResultDiv(flag,msg) {
            	$("#save_result_info").append(msg);
                var divResult = document.getElementById("save_result_info");
                if (flag)
                    divResult.style.display = "block";
                else
                    divResult.style.display = "none";
            }
        </script>
    </head>
    <body>
         <%@include file="../../include/navi.jsp" %>
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">            
            <div id="save_result_info" class="save_success" sytle="display:none"></div>
            <form action="${pageContext.request.contextPath }/admin/user_modi_pwd_do" method="post" class="main_form">
                    <div class="text_info clearfix"><span>姓名：</span></div>
                    <div class="input_info">
                        <input type="text" name="aname" value="${admin.aname }" />
                        <span class="required"></span>
                        <div class="validate_msg_long error_msg" style="display:none"></div>
                    </div>
                    <div class="text_info clearfix"><span>管理员账号：</span></div>
                    <div class="input_info"><input type="text" readonly="readonly" class="readonly" name="acname" value="${admin.acname }"  /></div>
                    <div class="text_info clearfix"><span>电话：</span></div>
                    <div class="input_info">
                        <input type="text" name="atel" value="${admin.atel }"  />
                        <span class="required"></span>
                        <div class="validate_msg_long error_msg" style="display:none"></div>
                    </div>
                    <div class="text_info clearfix"><span>Email：</span></div>
                    <div class="input_info">
                        <input type="text" class="width200" name="aemail" value="${admin.aemail }"/>
                        <span class="required"></span>
                        <div class="validate_msg_medium error_msg" style="display:none"></div>
                    </div>
                    <div class="text_info clearfix"><span>角色：</span></div>
                    <div class="input_info_high">
                        <div class="input_info_scroll">
                            <ul> 
                            <c:forEach items="${rolelist }" var="role">
                            <li><input type="checkbox" name="role" value="${role.id }"
                             <c:forEach items="${admin.RL }" var="arole">
                              <c:if test="${arole.id==role.id }">
                              checked="checked"
                              </c:if> 
                             </c:forEach>
                            />${role.rname }</li>
                         </c:forEach>                                         
                            </ul>
                        </div>
                        <span class="required"></span>
                        <div class="validate_msg_tiny error_msg" style="display:none"></div>
                    </div>
                    <div class="button_info clearfix">
                        <input type="button" value="保存" class="btn_save" id="smit" />
                        <input type="button" value="取消" class="btn_save" />
                    </div>
                    <input type="hidden" name="aid" value="${admin.id }">
                 </form>  
        </div>
        <!--主要区域结束-->
        <div id="footer">
           
        </div>
    </body>
</html>
