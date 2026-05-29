from flask import Flask, jsonify, request
app = Flask('UserManagement')

@app.route('/api/v1/users', methods=['GET'])
def get__users():
    return jsonify({'message': 'Endpoint /api/v1/users ejecutado con exito'}), 200

@app.route('/api/v1/users', methods=['POST'])
def post__users():
    return jsonify({'message': 'Endpoint /api/v1/users ejecutado con exito'}), 200

@app.route('/api/v1/users/<id>', methods=['GET'])
def get__users_id():
    return jsonify({'message': 'Endpoint /api/v1/users/<id> ejecutado con exito'}), 200

@app.route('/api/v1/users/<id>', methods=['PUT'])
def put__users_id():
    return jsonify({'message': 'Endpoint /api/v1/users/<id> ejecutado con exito'}), 200

@app.route('/api/v1/users/<id>', methods=['DELETE'])
def delete__users_id():
    return jsonify({'message': 'Endpoint /api/v1/users/<id> ejecutado con exito'}), 200

if __name__ == '__main__':
    app.run(debug=True, port=5000)