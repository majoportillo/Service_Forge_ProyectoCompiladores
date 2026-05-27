from flask import Flask, jsonify, request
app = Flask('MiApiIncreible')

@app.route('/api/listar', methods=['GET'])
def get__listar():
    return jsonify({'message': 'Endpoint /api/listar ejecutado con exito'}), 200

@app.route('/api/crear', methods=['POST'])
def post__crear():
    return jsonify({'message': 'Endpoint /api/crear ejecutado con exito'}), 200

@app.route('/api/buscar/<id>', methods=['GET'])
def get__buscar_id():
    return jsonify({'message': 'Endpoint /api/buscar/<id> ejecutado con exito'}), 200

if __name__ == '__main__':
    app.run(debug=True, port=5000)