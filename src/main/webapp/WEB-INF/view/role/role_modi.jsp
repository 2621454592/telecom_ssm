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
            $(function () {
				 $("#smit").click(function () {
					$(".main_form").submit();
				})
				var emsg='${msg}';
				if(emsg!=""){
					showResult(emsg);
				}
			})
            function showResult(emsg) {
                showResultDiv(true,emsg);
                window.setTimeout("showResultDiv(false,'');", 3000);
            }
            function showResultDiv(flag,emsg) {
            	$("#save_result_info").append(emsg);
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
            <!--保存操作后的提示信息：成功或者失败-->
            <div id="save_result_info" class="save_success" style="display:none" ></div>
            <form action="${pageContext.request.contextPath }/role/UpdateAction" method="post" class="main_form">
                <div class="text_info clearfix"><span>角色名称：</span></div>
                <div class="input_info">
                    <input type="text" class="width200" name="rname" value="${role.rname }" />
                    <span class="required"></span>
                    <div class="validate_msg_medium error_msg"></div>
                </div>       
                           
                <div class="text_info clearfix"><span>设置权限：</span></div>
                <div class="input_info_high">
                    <div class="input_info_scroll">
                        <ul>
                         <c:forEach items="${powerlist }" var="power">
                            <li><input type="checkbox" name="power" value="${power.id }"
                             <c:forEach items="${role.listpower }" var="rpower" >
                              <c:if test="${rpower.id==power.id }">
                              checked="checked"
                              </c:if> 
                             </c:forEach>
                            />${power.pname }</li>
                         </c:forEach>
                        </ul>
                    </div>
                    <span class="required">*</span>
                    <div class="validate_msg_tiny">至少选择一个权限</div>
                </div>
                <div class="button_info clearfix">
                    <input type="button" value="保存" class="btn_save" id="smit" />
                    <input type="button" value="取消" class="btn_save" />
                </div>
                <input type="hidden" name="rid" value="${role.id }" />
            </form> 
        </div>
        <!--主要区域结束-->
        <div id="footer">
            
        </div>
    </body>
</html>
