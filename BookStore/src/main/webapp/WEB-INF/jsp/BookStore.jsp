<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book-Store</title>
<style type="text/css">
	* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

body {
    font-family: Arial, sans-serif;
    background: url(./Web-development-concept-with-person-using-a-laptop-computer.jpeg); background-size: cover; background-repeat: no-repeat;
}

nav {
    display: flex;
    justify-content: space-between;
    align-items: center;
    height: 80px;
    color: black;
}

.logo {
    font-size: 24px;
    font-weight: bold;
    padding-left: 20px;
}

.nav-links {
    display: flex;
    align-items: center;
}

.nav-links .search {height: 30px; background: none; color: black; border: none; margin-right: 10px ; border-bottom: 2px solid; font-size: large; text-align: center;}
.nav-links .button {height: 30px; width: 70px; margin-right: 30px; background: none; border: none;  border-bottom: 2px solid; text-align: center; font-size: large; font-family: Arial, Helvetica, sans-serif;}
.nav-links .button a{text-decoration: none; color: black;}
.flow-right{ transition-duration: 6s; color: black; font-family: Arial, Helvetica, sans-serif;}

.list-items{margin-top: 20px;}

.list-items ul li {margin: 30px; list-style-type: none; text-decoration: none; color: black; font-size: large; font-family: Arial, sans-serif; width: 170px; height: 40px;  padding: 10px; font-weight: bold;}

.list-items ul li a {text-decoration: none; color: black;}

.list-items ul li:hover {border: 2px solid; color: rgb(152, 152, 116);}

.login{margin-left: 350px; }

.nav-links .search::placeholder{color: black;}
	
</style>
<body>
	<nav>
        <div class="logo">Book Store</div>
        <div class="nav-links">
            <input type="search" class="search" id="" placeholder="Type Something..."">
            <button class="button"><a href="#">search</a></button>
        </div>
    </nav>
    <div class="flow-right">
        <marquee behavior="" direction="right">Welcome to online book store...</marquee>
    </div>
    <div class="list-items">
        <ul>
            <li><a href="http://127.0.0.1:5500/login.html" target="_blank">Login</a></li>
            <li><a href="http://127.0.0.1:5500/AddBooks.html" target="_blank">Add Books</a> </li>
            <li><a href="http://127.0.0.1:5500/FindBook.html" target="_blank">Find Book</a> </li>
            <li><a href="http://127.0.0.1:5500/RemoveBook.html" target="_blank">Remove Books</a></li>
            <li><a href="#">Logout</a></li>
        </ul>
    </div>
</body>
</html>