<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8"/>
        <title>Додавання покупця</title>
    </head>

    <body>
        <h2>Додати нового покупця</h2>

        <form action="add" method="POST" accept-charset="utf-8">

            <p>Як звати</p>
            <input type="text" name="name"/>

            <p>Адреса</p>
            <input type="text" name="address"/>

            <br>
            <input type="submit" value="Додати покупця"/>
        </form>

    </body>

</html>