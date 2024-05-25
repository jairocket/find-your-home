import React from 'react';
/* import 'src/App.css'; */
/*import { Link } from 'react-router-dom' */


export default function SignUpPage() {
    return (
        <div className="register">
            <div className="convite">
                <h2>Junte-se a nós</h2>
                <h5>Crie sua conta e anuncie conosco</h5>
            </div>
            
            <div className='form'>
                <form action="/home">
                <p>
                    <label>Nome de usuário</label><br/>
                    <input type="text" name="first_name" required />
                </p>
                <p>
                    <label>Email</label><br/>
                    <input type="email" name="email" required />
                </p>
                <p>
                    <label>Senha</label><br/>
                    <input type="password" name="password" requiredc />
                </p>
                <p>
                    <input type="checkbox" name="checkbox" id="checkbox" required /> <span>Concordo com todos os termos <a href="https://google.com" target="_blank" rel="noopener noreferrer">termos de serviços</a></span>.
                </p>
                <p>
                    <button id="sub_btn" type="submit">Registrar-se</button>
                </p>
            </form>
            </div>
            
            {/* <footer>
                <p><Link to="/">Back to Homepage</Link>.</p> 
            </footer>  */}
        </div>
    )
}

