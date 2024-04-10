<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-TW">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>新增會員資料</title>

    <!-- 自定義 Bootstrap 樣式表 -->
    <link href="../notice/css/style.css" rel="stylesheet">

    <style>

        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f4f4f4;
        }

        .container {
            max-width: 600px;
            margin: 50px auto;
            padding: 30px;
            background: #fff;
            border-radius: 10px;
            box-shadow: 0px 0px 20px rgba(0,0,0,0.1);
        }

        h1 {
            color: #333;
            text-align: center;
            margin-bottom: 30px;
        }

        form {
            margin-top: 20px;
        }

        .form-group {
            margin-bottom: 20px;
        }

        .error-msg {
            color: red;
        }

        .btn-submit {
            width: 100%;
            padding: 12px;
            border: none;
            background-color: blue;
            color: white;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .btn-submit:hover {
            background-color: blue;
        }

        .form-control:focus {
            border-color: blue;
            box-shadow: none;
        }

        .form-label {
            font-weight: bold;
            color: #555;
        }

        .background-pattern {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-image: url('https://i.ibb.co/q0h81zM/background-pattern.jpg');
            background-size: cover;
            opacity: 0.15;
            z-index: -1;
        }

        /* 隐藏错误列表 */
        .error-list {
            display: none;
        }

        /* 漂亮的驗證碼格子樣式 */
        #Inpt {
            width: 100px;
            height: 40px;
            font-size: 20px;
            border: 2px solid #ccc;
            border-radius: 5px;
            margin-bottom: 10px;
            text-align: center;
        }

        /* 漂亮的驗證碼檢查提示訊息 */
        #Info {
            font-size: 16px;
            font-weight: bold;
            margin-bottom: 10px;
        }

        /* 驗證碼檢查錯誤時的提示訊息 */
        .error-msg {
            font-size: 14px;
            color: #ab5755;
            margin-top: 5px;
        }

        /* 驗證碼檢查正確時的提示訊息 */
        .success-msg {
            font-size: 14px;
            color: green;
            margin-top: 5px;
        }

        /* 更新按鈕樣式 */
        .submit-btn-container {
            display: inline-block;
            padding: 10px 20px;
            margin-right: 10px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .submit-btn-container:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

<div class="background-pattern"></div>

<div class="container">

    <h1>新增會員資料</h1>

    <form name="form1" action="/member/MemberServlet" method="POST">

        <%-- 錯誤列表 --%>
        <c:if test="${not empty errorMsgs}">
            <ul class="error-list">
                <c:forEach var="message" items="${errorMsgs}">
                    <li style="color:red">${message.value}</li>
                </c:forEach>
            </ul>
        </c:if>

        <div class="form-group">
            <label for="mName" class="form-label">會員姓名</label>
            <input type="text" id="mName" name="mName" class="form-control" value="${param.mName}" required>
            <span class="error-msg">${errorMsgs.mName}</span>
        </div>

        <div class="form-group">
            <label for="memAcc" class="form-label">會員帳號</label>
            <input type="text" id="memAcc" name="memAcc" class="form-control" value="${param.memAcc}" required>
            <span class="error-msg">${errorMsgs.memAcc}</span>
        </div>

        <div class="form-group">
            <label for="memPwd" class="form-label">會員密碼</label>
            <input type="password" id="memPwd" name="memPwd" class="form-control" required>
            <span class="error-msg">${errorMsgs.memPwd}</span>
        </div>

        <div class="form-group">
            <label for="memMob" class="form-label">手機號碼</label>
            <input type="text" id="memMob" name="memMob" class="form-control" value="${param.memMob}" required>
            <span class="error-msg">${errorMsgs.memMob}</span>
        </div>

        <div class="form-group">
            <label for="mGender" class="form-label" data-required="required">性別</label>
            <select id="mGender" name="mGender" class="form-control">
                <option value="1" ${param.mGender == '1' ? 'selected' : ''}>男</option>
                <option value="2" ${param.mGender == '2' ? 'selected' : ''}>女</option>
            </select>
            <span class="error-msg">${errorMsgs.mGender}</span>
        </div>

        <div class="form-group">
            <label for="memMail" class="form-label" data-required="required">電子郵件</label>
            <input type="email" id="memMail" name="memMail" class="form-control" value="${param.memMail}" required>
            <span class="error-msg">${errorMsgs.memMail}</span>
        </div>

        <div class="form-group">
            <label for="memAdd" class="form-label">地址</label>
            <input type="text" id="memAdd" name="memAdd" class="form-control" value="${param.memAdd}" required>
            <span class="error-msg">${errorMsgs.memAdd}</span>
        </div>

        <div class="form-group">
            <label for="memBd" class="form-label" data-required="required">會員生日</label>
            <input type="date" id="memBd" name="memBd" class="form-control" value="${param.memBd}" required>
            <span class="error-msg">${errorMsgs.memBd}</span>
        </div>

        <div class="form-group">
            <label for="memCard" class="form-label">信用卡</label>
            <input type="text" id="memCard" name="memCard" class="form-control" value="${param.memCard}" required>
            <span class="error-msg">${errorMsgs.memCard}</span>
        </div>

        <br>
        <div class="CodeCheck">
            <p id="Info">驗證碼</p>
            <input type="text" id="Inpt" disabled>
            <input type="text" id="Ans">
            <br>
            <button id="Check" class="submit-btn-container">檢查驗證碼是否正確</button>
            <button id="Gen" class="submit-btn-container">產生新的驗證碼</button>
            <script src="../notice/js/VerificationCode.js"></script>
        </div>
        <br>

        <input type="hidden" class="btn btn-submit" name="action" value="insert">
        <button type="button" class="btn btn-submit" id="submitBtn">送出新增</button>

    </form>
</div>

<script>

    // 綁定送出按鈕的點擊事件
    document.getElementById("submitBtn").addEventListener('click', function(event) {
        // 阻止預設行為
        event.preventDefault();
        // 顯示錯誤列表
        document.querySelector('.error-list').style.display = 'block';
        // 檢查驗證碼是否正確
        var isCodeCorrect = checkVerificationCode();
        // 如果驗證碼正確，返回 true，允許提交表單
        if (isCodeCorrect) {
            confirm('資料都確認好了嗎？要送出新增囉~');
            document.forms["form1"].submit();
        }
    });

    // 綁定產生新驗證碼按鈕的點擊事件
    document.getElementById("Gen").addEventListener('click', function(event) {
        // 阻止預設行為
        event.preventDefault();
        // 清空輸入框
        document.getElementById("Ans").value = "";
        document.getElementById("Inpt").value = "";
        // 產生新的驗證碼
        generate();
    });

    // 綁定檢查驗證碼按鈕的點擊事件
    document.getElementById("Check").addEventListener('click', function(event) {
        // 阻止預設行為
        event.preventDefault();
        // 檢查驗證碼是否正確
        checkVerificationCode();
    });

    // 檢查驗證碼是否正確的函數
    function checkVerificationCode() {
        var userCode = document.getElementById('Ans').value.trim();
        var generatedCode = document.getElementById('Inpt').value.trim();
        if (userCode === generatedCode) {
            // 如果驗證碼正確，返回 true
            return true;
        } else {
            // 如果驗證碼錯誤，提示錯誤信息
            alert('請輸入正確的驗證碼！');
            return false;
        }
    }

</script>

</body>
</html>
