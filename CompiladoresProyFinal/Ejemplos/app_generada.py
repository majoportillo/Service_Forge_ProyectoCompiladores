from flask import Flask, jsonify, request
app = Flask('ReportesService')

@app.route('/api/reportes', methods=['GET'])
def get__reportes():
    return jsonify({'message': 'Endpoint /api/reportes ejecutado con exito'}), 200

@app.route('/api/reportes/<id>', methods=['GET'])
def get__reportes_id():
    return jsonify({'message': 'Endpoint /api/reportes/<id> ejecutado con exito'}), 200

@app.route('/api/reportes', methods=['POST'])
def post__reportes():
    return jsonify({'message': 'Endpoint /api/reportes ejecutado con exito'}), 200

@app.route('/api/reportes/<id>', methods=['PATCH'])
def patch__reportes_id():
    return jsonify({'message': 'Endpoint /api/reportes/<id> ejecutado con exito'}), 200

@app.route('/api/reportes/<id>', methods=['DELETE'])
def delete__reportes_id():
    return jsonify({'message': 'Endpoint /api/reportes/<id> ejecutado con exito'}), 200

@app.route('/api/reportes/<id>/detalles', methods=['GET'])
def get__reportes_id_detalles():
    return jsonify({'message': 'Endpoint /api/reportes/<id>/detalles ejecutado con exito'}), 200

@app.route('/api/reportes/<id>/detalles', methods=['POST'])
def post__reportes_id_detalles():
    return jsonify({'message': 'Endpoint /api/reportes/<id>/detalles ejecutado con exito'}), 200

@app.route('/api/reportes/<id>/detalles/<detalle_id>', methods=['DELETE'])
def delete__reportes_id_detalles_detalle_id():
    return jsonify({'message': 'Endpoint /api/reportes/<id>/detalles/<detalle_id> ejecutado con exito'}), 200

@app.route('/api/reportes/<id>/exportaciones', methods=['GET'])
def get__reportes_id_exportaciones():
    return jsonify({'message': 'Endpoint /api/reportes/<id>/exportaciones ejecutado con exito'}), 200

@app.route('/api/reportes/<id>/exportaciones', methods=['POST'])
def post__reportes_id_exportaciones():
    return jsonify({'message': 'Endpoint /api/reportes/<id>/exportaciones ejecutado con exito'}), 200

@app.route('/api/reportes/<id>/exportaciones/<exportacion_id>', methods=['GET'])
def get__reportes_id_exportaciones_exportacion_id():
    return jsonify({'message': 'Endpoint /api/reportes/<id>/exportaciones/<exportacion_id> ejecutado con exito'}), 200

if __name__ == '__main__':
    app.run(debug=True, port=5000)