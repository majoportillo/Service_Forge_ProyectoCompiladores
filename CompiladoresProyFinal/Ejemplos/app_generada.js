const express = require('express');
const app = express();
app.use(express.json());

app.get('/api/reportes', (req, res) => {
    res.status(200).json({ message: 'Endpoint /api/reportes ejecutado con éxito' });
});

app.get('/api/reportes/:id', (req, res) => {
    res.status(200).json({ message: 'Endpoint /api/reportes/:id ejecutado con éxito' });
});

app.post('/api/reportes', (req, res) => {
    res.status(200).json({ message: 'Endpoint /api/reportes ejecutado con éxito' });
});

app.patch('/api/reportes/:id', (req, res) => {
    res.status(200).json({ message: 'Endpoint /api/reportes/:id ejecutado con éxito' });
});

app.delete('/api/reportes/:id', (req, res) => {
    res.status(200).json({ message: 'Endpoint /api/reportes/:id ejecutado con éxito' });
});

app.get('/api/reportes/:id/detalles', (req, res) => {
    res.status(200).json({ message: 'Endpoint /api/reportes/:id/detalles ejecutado con éxito' });
});

app.post('/api/reportes/:id/detalles', (req, res) => {
    res.status(200).json({ message: 'Endpoint /api/reportes/:id/detalles ejecutado con éxito' });
});

app.delete('/api/reportes/:id/detalles/:detalle_id', (req, res) => {
    res.status(200).json({ message: 'Endpoint /api/reportes/:id/detalles/:detalle_id ejecutado con éxito' });
});

app.get('/api/reportes/:id/exportaciones', (req, res) => {
    res.status(200).json({ message: 'Endpoint /api/reportes/:id/exportaciones ejecutado con éxito' });
});

app.post('/api/reportes/:id/exportaciones', (req, res) => {
    res.status(200).json({ message: 'Endpoint /api/reportes/:id/exportaciones ejecutado con éxito' });
});

app.get('/api/reportes/:id/exportaciones/:exportacion_id', (req, res) => {
    res.status(200).json({ message: 'Endpoint /api/reportes/:id/exportaciones/:exportacion_id ejecutado con éxito' });
});

app.listen(3000, () => {
    console.log('Servidor ReportesService corriendo en http://localhost:3000');
});