<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>APIS</title>
</head>
<body>
    <form method="GET">
        <button type="submit" name="compañias">COMPAÑÍAS</button>
    </form>
    <form method="GET">
        <button type="submit" name="libros">LIBROS</button>
    </form>
    <form method="GET">
        <button type="submit" name="personas">PERSONAS</button>
    </form>
    <textarea id="informacion" rows="30" cols="100"><?php
    if ($_SERVER["REQUEST_METHOD"] == "GET" && isset($_GET["compañias"])) {
        $url = "https://fakerapi.it/api/v2/companies?_quantity=5";
        $response = file_get_contents($url);
        $data = json_decode($response, true);
        $informacion = '';
        foreach ($data['data'] as $empresa) {
            $informacion .= "Nombre: " . htmlspecialchars($empresa['name']) . "\n";
            $informacion .= "País: " . htmlspecialchars($empresa['country']) . "\n";
            $informacion .= "Teléfono: " . htmlspecialchars($empresa['phone']) . "\n\n";
        }

        echo $informacion;
    }
    if ($_SERVER["REQUEST_METHOD"] == "GET" && isset($_GET["libros"])) {
        $url = "https://fakerapi.it/api/v2/books?_quantity=5";
        $response = file_get_contents($url);
        $data = json_decode($response, true);
        $informacion = '';
        foreach ($data['data'] as $libro) {
            $informacion .= "Titulo: " . htmlspecialchars($libro['title']) . "\n";
            $informacion .= "Autor: " . htmlspecialchars($libro['author']) . "\n";
            $informacion .= "Descripción: " . htmlspecialchars($libro['description']) . "\n\n";
        }

        echo $informacion;
    }
    if ($_SERVER["REQUEST_METHOD"] == "GET" && isset($_GET["personas"])) {
        $url = "https://fakerapi.it/api/v2/persons?_quantity=5";
        $response = file_get_contents($url);
        $data = json_decode($response, true);
        $informacion = '';
        foreach ($data['data'] as $persona) {
            $informacion .= "Nombre: " . htmlspecialchars($persona['firstname']) . "\n";
            $informacion .= "Apellido: " . htmlspecialchars($persona['lastname']) . "\n";
            $informacion .= "Cumpleaños: " . htmlspecialchars($persona['birthday']) . "\n\n";
        }

        echo $informacion;
    }
    ?>
    </textarea>

</body>
</html>
