<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
        <%@include file="../../include/header.jsp" %>
        <script language="javascript" type="text/javascript">
           $(function() {
        	   $("#smit").click(function() {
    			   $.post({
    				    url: '${pageContext.request.contextPath }/admin/user_info_do',
    				    data: $(".main_form").serialize(),
    				    success: function(result) {
							showResult(result);
						}
    			   })
    		})
		})
            //保存成功的提示信息
            function showResult(result) {
        	   var m;
        	   if("ok"==result){
        		   m="修改成功";
        	   }else{
        		   m="修改失败";
        	   }
        	   $("#save_result_info").text(m);
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
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">            
            <!--保存操作后的提示信息：成功或者失败-->
            <div id="save_result_info" class="save_success"></div><!--保存失败，数据并发错误！-->
            <form action="" method="" class="main_form">
                <div class="text_info clearfix"><span>管理员账号：</span></div>
                <div class="input_info"><input type="text" readonly="readonly" class="readonly" name="acname" value="${admin.acname }" /></div>
                <div class="text_info clearfix"><span>角色：</span></div>
                <div class="input_info">
                    <input type="text" readonly="readonly" class="readonly width400" name="role"  value="${admin.roleList }"/>
                </div>
                <div class="text_info clearfix"><span>姓名：</span></div>
                <div class="input_info">
                    <input type="text" name="name" value="${admin.aname }"/>
                    <span class="required"></span>
                    <div class="validate_msg_long error_msg"></div>
                </div>
                <div class="text_info clearfix"><span>电话：</span></div>
                <div class="input_info">
                    <input type="text" class="width200" name="tel" value="${admin.atel }"/>
                    <div class="validate_msg_medium"></div>
                </div>
                <div class="text_info clearfix"><span>Email：</span></div>
                <div class="input_info">
                    <input type="text" class="width200" name="email"  value="${admin.aemail }"/>
                    <div class="validate_msg_medium"></div>
                </div>
                <div class="text_info clearfix"><span>创建时间：</span></div>
                <div class="input_info"><input type="text" readonly="readonly" class="readonly" value="${admin.createTime }"/></div>
                <div class="button_info clearfix">
                    <input type="button" value="保存" class="btn_save" id="smit" />
                    <input type="button" value="取消" class="btn_save" />
                </div>
                 <input type="hidden" name="aid" value="${admin.id }" />
            </form>  
        </div>
        <!--主要区域结束-->
        <div id="footer">
          
        </div>
    </body>
</html>
