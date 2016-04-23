<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form name="form1" method="post" action="loginProcess">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
<table>
    <tr height="40px">
        <td>유저ID</td>
        <td><input type="text" name="id"></td>
    </tr>
    <tr height="40px">
        <td>패스워드</td>
        <td><input type="password" name="pw"></td>
    </tr>
</table>
<table>
    <tr>
        <td align="center"><input type="submit" value="로그인"></td>
        <td align="center"><input type="reset" value="리셋"></td>
    </tr>
</table>
</form>