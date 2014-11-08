<%-- 
    Document   : index
    Created on : 16/10/2014, 05:44:51 PM
    Author     : cobrakik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="js/jquery.min.js"></script>
        <script type="text/javascript" src="js/mespeak.js?v=1.9.6"></script>
        <script type="text/javascript" src="js/reconoserTexto.js"></script>
        <script type="text/javascript" src="js/reconoserVoz.js"></script>
    </head>
    <body>
        <div>
            <button id="escuchar" onclick="obtenerTexto()" type="button" class="btn btn-default">
                Escuchar
            </button>
            <input id="txtMainPublicacion" type="hidden">
            <!--
            <textarea id="txtMainPublicacion" name="post" required="true"></textarea>
            -->
            <input type="hidden" speech x-webkit-speech id="reconocimiento" name="reconocimiento" />
        </div>
        <div id="salida"></div>
    </body>
</html>
