<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>데이터 테스트</title>
</head>

<script type="text/javascript">
  let userId = '${userId}';
  let email = '${email}';
  let name = '${name}';
  window.onload = function(){
    console.log("userId : " + userId);
    console.log("email : " + email);
    console.log("name : " + name);
    PacApp._appleLogin(userId, email, name);
  };

</script>
<body>
<h1>userId : ${userId}</h1>
<h1>email : ${email}</h1>
<h1>name : ${name}</h1>
</body>
</html>