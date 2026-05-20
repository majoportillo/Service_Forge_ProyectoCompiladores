const express = require('express');
const app = express();
app.use(express.json());

app.get('/api/v1/users', (req, res) => {
    res.status(200).json({ message: 'Endpoint /api/v1/users ejecutado con éxito' });
});

app.post('/api/v1/users', (req, res) => {
    res.status(200).json({ message: 'Endpoint /api/v1/users ejecutado con éxito' });
});

app.get('/api/v1/users/:id', (req, res) => {
    res.status(200).json({ message: 'Endpoint /api/v1/users/:id ejecutado con éxito' });
});

app.listen(3000, () => {
    console.log('Servidor Users corriendo en http://localhost:3000');
});