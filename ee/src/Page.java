
public class Page {
    String loginPage() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<!DOCTYPE html>").
                append("<html lang=\"en\">").
                append("<head>").
                append("<style type=\"text/css\">").
                append("body{background: #c2c2c2;}" +
                        ".buttons{padding: 25px;}" +
                        "form{padding:40px; background:#ccc;position: fixed; top: 50%; left: 50%; transform: translate(-50%, -50%);}" +
                        ".login {padding-bottom: 10px;}" +
                        ".buttons{padding-left: 20px; padding-top: 25px;}" +
                        " span button{width:60px}").
                append("</style>").
                append("<meta charset=\"UTF-8\">").
                append("<title>GAme</title>").
                append("</head>").
                append("<body>").
                append("<form action=\"http://localhost:8080/hello\" method=\"post\" >").
                append("<div class=\"login\">").
                append("<input type=\"text\" placeholder=\"login\" name=\"login\"/>").
                append("</div>").
                append("<div class=\"password\">").
                append("<input type=\"password\" placeholder=\"password\" name=\"password\"/>").
                append("</div>").
                append("<div class=\"buttons\">").
                append("<span> <button type=\"LogIn\"> Submit </button> </span>").
                append("<span> <button type=\"Reset\"> Reset </button> </span>").
                append("</div>").
                append("</form>").
                append("</body>").
                append("</html>");
        return stringBuilder.toString();
    }
    String wrongPassword(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<!DOCTYPE html>").
                append("<html lang=\"en\">").
                append("<head>").
                append("<style type=\"text/css\">").
                append("body{background: #c2c2c2;}" +
                        ".buttons{padding: 25px;}" +
                        "form{padding:40px; background:#ccc;position: fixed; top: 50%; left: 50%; transform: translate(-50%, -50%);}" +
                        ".login {padding-bottom: 10px;}" +
                        ".buttons{padding-left: 20px; padding-top: 25px;}" +
                        " span button{width:60px}").
                append("</style>").
                append("<meta charset=\"UTF-8\">").
                append("<title>GAme</title>").
                append("</head>").
                append("<body>").
                append("<form action=\"http://localhost:8080/hello\" method=\"post\">").
                append("<div class=\"login\">").
                append("<input type=\"text\" placeholder=\"login\" name=\"login\"/>").
                append("</div>").
                append("<div class=\"password\">").
                append("<input type=\"password\" placeholder=\"Wrong password\" name=\"password\" style=\"background-color:#FFDAB9\"/>").
                append("</div>").
                append("<div class=\"buttons\">").
                append("<span> <button type=\"submit\"> Submit </button> </span>").
                append("<span> <button type=\"reset\"> Reset </button> </span>").
                append("</div>").
                append("</form>").
                append("</body>").
                append("</html>");
        return stringBuilder.toString();
    }

    String mainPage(String name, int health, int rating){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<!DOCTYPE html>").append("<html lang=\"en\">").
                append("<head>").
                append("<style type=\"text/css\">").
                append("form button" +
                        "{width: 175px;" +
                        " height: 41px;" +
                        " background: linear-gradient(to bottom, #fcfcfc, #c9c9c9);}" +
                        ".buttons{position: absolute;" +
                        "    top: 50%;" +
                        "    left: 50%;}").
                append("</style>").
                append("<meta charset=\"UTF-8\">").
                append("<title>Main Menu</title>").
                append("</head>").
                append("<body> <div class=\"buttons\">").
                append("<div> <form action=\"http://localhost:8080/hello\" method=\"get\">").
                append("<input type=\"hidden\" name=\"userName\" value=\"").append(name).append("\"/>").
                append("<input type=\"hidden\" name=\"userHealth\" value=\"").append(health).append("\"/>").
                append("<input type=\"hidden\" name=\"userRating\" value=\"").append(rating).append("\"/>").
                append("<button type=\"submit\" name = \"num\" value=\"Fight\"> Fight </button>").
                append("</form> </div>").
                append("<div style=\"padding-top: 15px\">").
                append("<form action=\"http://localhost:8080/hello\" method=\"get\">").
                append("<button type=\"submit\"> Exit </button>").
                append("</div> <div>").
                append("</body>").
                append("</html>");
        return stringBuilder.toString();
    }
    String fightPage(String userName, String userRating){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<!DOCTYPE html>").append("<html lang=\"en\">").
                append("<head>").
                append("<style>").
                append(" body {background: #c5c4d3;}" +
                        ".user{padding: 100px;" +
                        "    background: #ccc;" +
                        "    position: fixed;" +
                        "    top: 50%;" +
                        "    left: 50%;" +
                        "    transform: translate(-50%, -50%);}" +
                        ".userName{top: -40px;" +
                        "    left: 35px;" +
                        "    font-size: 25px;" +
                        "    position: absolute;" +
                        "    font-family: cursive;}" +
                        ".userRating1{font-size: 80px;" +
                        "    color: #8883d1;" +
                        "    top: 35px;" +
                        "    left: 73px;" +
                        "    position: absolute;}" +
                        ".userRating2{position: absolute;" +
                        "    top: 120px;" +
                        "    left: 65px;" +
                        "    font-size: 20px;}" +
                        ".form{position: absolute;" +
                        "    top: 560px;" +
                        "    left: 535px;}").
                append("</style>").
                append("<meta charset=\"UTF-8\">").
                append("<title>Main Menu</title>").
                append("</head>").
                append("<body>").
                append("<div class=\"form\"> <form action=\"http://localhost:8080/hello\" method=\"get\">").
                append("<input type=\"submit\" name=\"num\" value=\"Begin\"" +
                        " style=\" width: 175px; height: 41px;\"" +
                        "\" background: linear-gradient(to bottom, #fcfcfc, #c9c9c9);\">").
                append("</form> </div>").
                append("<div class=\"user\">").
                append("<div class=\"userName\"> <span> Name" + userName + " </span> </div>").
                append("<div> <span class=\"userRating1\">" + userRating + "</span></div>").append("<span class=\"userRating2\"> Rating </span>").
                append("</div>").
                append("</body>").
                append("</html>");
        return stringBuilder.toString();
    }
}
