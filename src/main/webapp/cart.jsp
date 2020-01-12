<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html;UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/jquery-3.1.1.min.js"></script>
    <title>Document</title>
    <script>

        function sale() {
            $.ajax({
                url:"http://localhost:9002/getCart",
                datatype:"json",
                success:function (data) {
                    alert("购买成功:订单编号:"+data.data.orderId);
                }

            });
        }
    </script>
</head>
<body>


      <div class="row">
          <div class="col-sm-3"></div>
          <div class="col-sm-7">
              <div class="bs-example" data-example-id="hoverable-table">
                  <table class="table table-hover">
                      <thead>
                      <tr><h1 style="align-content: center">购物车</h1></tr>
                      <tr>
                          <th>商品名</th>
                          <th> 单价</th>
                          <th>数量</th>
                          <th>小计</th>
                          <th>总价</th>
                      </tr>
                      </thead>
                      <tbody>
                      <c:forEach items="${cart.items}" var="i">
                          <tr>
                              <th scope="row">${i.value.productInfo.prodcutName}</th>
                              <td>${i.value.productInfo.productPrice}</td>
                              <td>${i.value.count}</td>
                              <td>${i.value.smallTotal} </td>
                          </tr>
                      </c:forEach>
                      <tr>
                         <th></th><th></th><th></th><th></th> <th> ${cart.totalPrice}</th>
                      </tr>
                     <tr>
                          <th></th><th></th><th></th><th></th> <th><a href="#"  onclick="sale();" class="btn btn-danger">结算</a></th>
                      </tr>

                      </tbody>
                  </table>
              </div>
          </div>
          <div class="col-sm-2"></div>
      </div>

</body>
</html>