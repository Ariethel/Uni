<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>InTaberna - Music Store</title>
</head>

<body>

<!-- Navbar section -->
<nav class="navbar navbar-expand-md navbar-light bg-light">
    <div class="container-xxl">
      

        <!-- Logo -->
        <a class="navbar-brand" href="#">InTaberna</a>

        <!-- Menu hamburger navbar-->
        <button class="navbar-toggler btn-success" type="button" data-bs-toggle="collapse"
        data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
        aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>


      

        <!-- Parte di Navbar da collassare-->
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
        

            <!-- Search bar -->
            <form class="d-flex mt-3 flex-grow-1">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>


            
            <!-- Elementi Navbar -->
            <ul class="navbar-nav mb-lg-0">
                    <li class="nav-item dropdown me-4">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                        data-bs-toggle="dropdown" aria-expanded="false">
                            Login
                        </a>
                        <div class="dropdown-menu">
                            <form class="px-4 py-3">
                              <div class="form-group">
                                <label for="exampleDropdownFormEmail1">Email address</label>
                                <input type="email" class="form-control" id="exampleDropdownFormEmail1" placeholder="email@example.com">
                              </div>
                              <div class="form-group">
                                <label for="exampleDropdownFormPassword1">Password</label>
                                <input type="password" class="form-control" id="exampleDropdownFormPassword1" placeholder="Password">
                              </div>
                              <button type="submit" class="btn btn-primary">Sign in</button>
                            </form>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="#">Help</a>
                    </li>


                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="#">🛒</a>
                    </li>
            </ul>

           

        </div>
    </div>
</nav>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>

</html>