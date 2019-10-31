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
				if('${armsg }'!=''){
					showResult();
				}
			})
            function showResult() {
                showResultDiv(true);
                window.setTimeout("showResultDiv(false);", 3000);
            }
            function showResultDiv(flag) {
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
        <!--主要区域开始-->
        <div id="main">            
            <!--保存操作后的提示信息：成功或者失败-->
            <div id="save_result_info" class="save_success">${armsg }</div><!--保存失败，角色名称重复！-->
            <form action="${pageContext.request.contextPath }/role/roleadd_doadd" method="post" class="main_form">
                <div class="text_info clearfix"><span>角色名称：</span></div>
                <div class="input_info">
                    <input type="text" class="width200" name="rolename" />
                    <span class="required">*</span>
                    <div class="validate_msg_medium">不能为空，且为20长度的字母、数字和汉字的组合</div>
                </div>                    
                <div class="text_info clearfix"><span>设置权限：</span></div>
                <div class="input_info_high">
                    <div class="input_info_scroll">
                        <ul>
                            <c:forEach items="${powerlist }" var="power">
                            <li><input type="checkbox" name="power" value="${power.id }"/>${power.pname }</li>
                            </c:forEach>                       
                        </ul>
                    </div>
                    <span class="required">*</span>
                    <div class="validate_msg_tiny">至少选择一个权限</div>
                </div>
                <div class="button_info clearfix">
                    <input type="button" value="保存" class="btn_save" id="smit"/>
                    <input type="button" value="取消" class="btn_save" />
                </div>
            </form>
        </div>
        <!--主要区域结束-->
        <div id="footer">
          
        </div>
    </body>
</html>
