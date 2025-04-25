const express = require('express');
const fs = require('fs');
const path = require('path');
const morgan = require('morgan');
const useragent = require('useragent');

const app = express();
const PORT = process.env.PORT || 3000;
const LOG_FILE = path.join(__dirname, 'visits.log');

// Middleware для логирования
app.use((req, res, next) => {
  const ip = req.ip || req.connection.remoteAddress;
  const userAgent = useragent.parse(req.headers['user-agent']);
  const logEntry = `[${new Date().toISOString()}] IP: ${ip} | Device: ${userAgent.toString()}\n`;

  fs.appendFile(LOG_FILE, logEntry, (err) => {
    if (err) console.error('Ошибка записи лога:', err);
  });

  next();
});

// Раздача статики
app.use(express.static(path.join(__dirname, '../public')));

// Запуск сервера
app.listen(PORT, () => {
  console.log(`Сервер запущен на порту ${PORT}`);
  console.log(`Логи сохраняются в: ${LOG_FILE}`);
});
