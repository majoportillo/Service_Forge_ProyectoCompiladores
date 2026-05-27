const express = require('express');
const app = express();
app.use(express.json());

app.get('/api/listar', (req, res) => {
    res.status(200).json({ message: 'Endpoint /api/listar ejecutado con éxito' });
});

app.post('/api/crear', (req, res) => {
    res.status(200).json({ message: 'Endpoint /api/crear ejecutado con éxito' });
});

app.get('/api/buscar/:id', (req, res) => {
    res.status(200).json({ message: 'Endpoint /api/buscar/:id ejecutado con éxito' });
});

app.listen(3000, () => {
    console.log('Servidor MiApiIncreible corriendo en http://localhost:3000');
});