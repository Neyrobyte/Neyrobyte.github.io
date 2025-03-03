<?php
   $data = json_decode(file_get_contents('php://input'), true);
   $ip = $data['ip'];
   file_put_contents('visitors.log', $ip . PHP_EOL, FILE_APPEND);
   ?>