<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<c:forEach begin="1" end="6" var="i">
<h${i}>Hello World!</h${i}>
</c:forEach>
</body>
</html>
