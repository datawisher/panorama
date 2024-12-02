const os = require('os');
const express = require('express');
const cors = require('cors');
const app = express();

app.use(cors());

app.get('/get-ip', (req, res) => {
  // 过滤末位为1的ip
  const ipRegex = /^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)(?<!1)$/;
  const interfaces = os.networkInterfaces();
  const ips = Object.values(interfaces)
    .flat()
    .filter((info) => info.family === 'IPv4' && !info.internal && ipRegex.test(info.address))
    .map((info) => info.address);
  res.json({ ip: ips });
});

app.listen(3000, () => console.log('Server running ..., local IP address is http://localhost:3000/get-ip'));
