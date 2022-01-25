<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <table>
        <tr>
            <th rowspan="4"></th>
        </tr>
        <tr>
            <td>아이디</td><td><input type="text" id="id" name="id"></td><td><div id="message"></div></td>
        </tr>
        <tr>
            <td>비밀번호</td><td><input type="password" id="pw" name="pw"></td>
            <td><input type="button" onclick="idCheck()" value="중복체크"></td>
        </tr>
        <tr>
            <td>이름</td><td><input type="text" id="name" name="name"></td>
            <td><input type="submit" value="등록" onclick="return inputCheck()" formaction="signUp.do"></td>
        </tr>
    </table>
</form>
<script>
    function idCheck() {
        let xhr = new XMLHttpRequest();
        xhr.onreadystatechange = () => {
            if (xhr.readyState === 4 && xhr.status === 200) {
                document.getElementById("message").innerText = xhr.responseText;
            }
        };
        let id = document.getElementById("id").value;
        xhr.open("GET", "IdCheck.do?id=" + id);
        xhr.send();
    }

    function inputCheck() {
        if (document.getElementById('message').textContent === '사용가능한 아이디입니다.') {
            if (document.getElementById('id').value.length === 0) {
                alert('아이디를 입력하세요');
                document.getElementById('id').focus();
                return false;
            } else if (document.getElementById('pw').value.length === 0) {
                alert('비밀번호를 입력하세요');
                document.getElementById('pw').focus();
                return false;
            } else if (document.getElementById("name").value.length === 0) {
                alert('이름을 입력하세요');
                document.getElementById('name').focus();
                return false;
            }
        } else if (document.getElementById('message').textContent === '아이디가 중복되었습니다.') {
            alert('다른 아이디를 입력해주세요.');
            return false;
        } else {
            alert('아이디를 입력하세요.');
            document.getElementById('id').focus();
            return false;
        }
    }
</script>
</body>
</html>
