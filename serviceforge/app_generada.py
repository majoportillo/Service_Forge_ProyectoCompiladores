from flask import Flask, jsonify, request
app = Flask('Users')

@app.route('/api/v1/users', methods=['GET'])
def get__users():
    return jsonify({'message': 'Endpoint /api/v1/users ejecutado con éxito'})

@app.route('/api/v1/users', methods=['POST'])
def post__users():
    return jsonify({'message': 'Endpoint /api/v1/users ejecutado con éxito'})

@app.route('/api/v1/users/<id>', methods=['GET'])
def get__users_id():
    return jsonify({'message': 'Endpoint /api/v1/users/<id> ejecutado con éxito'})

if __name__ == '__main__':
    app.run(debug=True, port=5000)