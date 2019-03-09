<%--
  Created by IntelliJ IDEA.
  User: 黄凯
  Date: 2018/7/21
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <title>首页</title>
    <style type="text/css">
      #content {
        border: 1px blue solid;
        width: 700px;
        height: 500px;
        position: relative;
        left: 100px;
        top:-50px;
      }
      h3 {
        text-align: center;
      }
    </style>
    <script type="text/javascript" src="statics/js/jquery-1.8.3.js"></script>
  </head>
  <body>
   <input type="hidden" name="userId" value="${users.id}">
  <h2>欢迎:${users.realName}&nbsp;&nbsp;
   <a href="javascript:void(0)" id="exit">退出登录</a>
  </h2>
  <div><a href="javascript:void(0)" id="xs">销售</a> </div>
  <div><a href="javascript:void(0)" id="sele">销售信息查询</a> </div>
  <div><a href="">查看库存</a> </div>
  <div id="content">
      <h3>欢迎使用小型进销存系统</h3>
  </div>
  <script type="text/javascript">
    $(function () {
        $("#exit").click(function () {
            if (confirm("确定要退出系统吗?")) {
                location.href="${pageContext.request.contextPath }/exit.htmls";
            }
        });
        $("#xs").click(function () {
            $.ajax({
                url:"add.htmls",
                type:"post",
                data:{},
                dataType:"json",
                success:function (data) {
                    var html = "<div><h4>添加销售:</h4><table><tr><td>商品名称:</td><td><select name='product'><option>--请选择商品--</option>";
                    for (var j=0;j<data.length;j++){
                        var product=data[j];
                      html+="<option value='"+product.id+"'>"+product.productName+"</option>";
                    }
                    html+="</select></td></tr><tr><td>销售单价:</td><td><input type='text' name='price'/></td></tr><tr>" +
                        "<td>销售数量:</td><td><input type='text' name='quantity'/></td></tr></table><button id='bc'>保存</button></div>";


                    $("#content").html(html);
                }
            })
        });
        $("#bc").live("click",function () {
            var productId=$("select[name=product]").val();
            var price=$("input[name=price]").val();
            var quantity=$("input[name=quantity]").val();
            var userId=$("input[name=userId]").val();
            $.ajax({
                url:"addSale.htmls",
                type:"post",
                data:{productId:productId,price:price,quantity:quantity,userId:userId},
                dataType:"json",
                success:function (data) {
                     if (data){
                         alert("添加成功")
                     } else{
                         alert("添加失败")
                     }
                }
            })

        })
        $("#sele").click(function () {
            var ord="";
           initSale(1,ord);
    });
        $(".first").live("click",function () {
            var page=$(this).prev().val();
            var ord=$(this).next().val();
            initSale(page,ord);
        });
        $(".up").live("click",function () {
            var page=$(this).prev().val()
            var ord=$(this).next().val();
            initSale(page,ord);
        });
        $(".down").live("click",function () {
            var page=$(this).prev().val()
            var ord=$("select[name=ord]").val();
            initSale(page,ord);
        });
        $(".end").live("click",function () {
            var page=$(this).prev().val()
            var ord=$(this).next().val();
            initSale(page,ord);
        });
        $(".tj").live("click",function () {
            var ord=$("select[name=ord]").val();
            initSale(1,ord);
        });
        function initSale(page,ord) {
            $.ajax({
                url:"selectSale.htmls",
                type:"post",
                data:{page:page,ord:ord},
                dataType:"json",
                success:function (data) {
                    var saleList=data.pageInfo.objList;
                     var ords=data.ordList;
                    var html = "<div>销售信息查询<span>排序方式:</span><select name='ord' ><option value='salDate' >销售日期</option>";
                    for (var j=0;j<ords.length;j++){
                        var ord1=ords[j];
                        if (ord==ord1.ordName) {
                            html+="<option selected value='"+ord1.ordName+"'>"+ord1.ordVal+"</option>"
                        }else{
                            html+="<option  value='"+ord1.ordName+"'>"+ord1.ordVal+"</option>"
                        }
                    }
                    html+="</select><button class='tj'>提交</button></div><table><tr><td>ID</td><td>商品</td><td>单价</td><td>数量</td><td>总价</td><td>销售日期</td><td>销售员</td></tr>"
                    for (var i=0;i<saleList.length;i++) {
                        var sale=saleList[i];
                        html +="<tr ><td>"+ sale.id+"</td><td>"+ sale.product.productName+"</td><td>"+ sale.price+"</td>" +
                            "<td>"+ sale.quantity+"</td><td>"+ sale.totalPrice+"</td><td>"+ sale.salDate+"</td><td>"+
                            sale.users.realName+"</td></tr>";
                    }
                    html+="<tr><td colspan='7'><input type='hidden' value='1'/><a href='#' class='first'> 首页</a><input type='hidden' value='"+data.ordl+"'/>" +
                        "<input type='hidden' value='"+(data.pageInfo.currPageNo-1)+"'/><a href='#' class='up'>上一页</a><input type='hidden' value='"+data.ordl+"'/>" +
                        "<input type='hidden' value='"+(data.pageInfo.currPageNo+1)+"'/><a href='#' class='down'>下一页</a><input type='hidden' value='"+data.ordl+"'/>" +
                        "<input type='hidden' value='"+(data.pageInfo.totalPageNum)+"'/><a href='#' class='end'>末页</a><input type='hidden' value='"+data.ordl+"'/></td></tr> "
                    $("#content").html(html);
                }
            })
        }
    });
  </script>
  </body>
</html>
