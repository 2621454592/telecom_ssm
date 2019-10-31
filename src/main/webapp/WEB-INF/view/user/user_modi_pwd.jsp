<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
        <%@include file="../../include/header.jsp" %>
        <script type="text/javascript">       
         $(function(){ 
        	 if('${emspwd}'!=''){
					showResult();
					}	
			 $("#smit").click(		 
					 function() {
							$("#pwdform").submit();
						    }		     		  
			       )
			  
		})
		
		//保存成功信息提示
		function showResult() {
			showResultDiv(true);
			window.setTimeout("showResultDiv(false);",3000);
		}
         
         //显示div块
         function showResultDiv(flag){
        	 if(flag){
        		 $("#save_result_info").css("display","block");
        	 }else{
        		 $("#save_result_info").css("display","none");
        	 }
         }
        
        </script>
    </head>
    <body>
        <%@include file="../../include/navi.jsp" %>
        <!--导航区域结束-->
        <div id="main">      
            <!--保存操作后的提示信息：成功或者失败-->      
            <div id="save_result_info" class="save_fail" style="display:none" >${emspwd }</div><!--保存失败，旧密码错误！-->
            <form id="pwdform" action="${pageContext.request.contextPath }/admin/user_modi_pwd_do" method="post" class="main_form">
                <div class="text_info clearfix"><span>旧密码：</span></div>
                <div class="input_info">
                    <input type="password" class="width200" name="oldpwd"  /><span class="required">*</span>
                    <div class="validate_msg_medium"></div>
                </div>
                <div class="text_info clearfix"><span>新密码：</span></div>
                <div class="input_info">
                    <input type="password"  class="width200" name="newpwd"/><span class="required">*</span>
                    <div class="validate_msg_medium"></div>
                </div>
                <div class="text_info clearfix"><span>重复新密码：</span></div>
                <div class="input_info">
                    <input type="password" class="width200"  /><span class="required">*</span>
                    <div class="validate_msg_medium"></div>
                </div>
                <div class="button_info clearfix">
                    <input type="button" value="保存" class="btn_save" id="smit" />
                    <input type="button" value="取消" class="btn_save" />
                </div>
            </form>  
        </div>
        <!--主要区域结束-->
        <div id="footer">
           
        </div>
    </body>
</html>
