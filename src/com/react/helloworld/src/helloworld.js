/**
 * Copy the function helloworld contents into the corresponding portion of App.js
 */

import './App.css';

function helloworld(){
    return(
        <div className="helloworld-app">
            <h1>Hello World!</h1>
            <p>This is my first React app!</p>
            <p>To know more about me professionally, visit my <a 
                    href="https://www.linkedin.com/in/dasde/" 
                    rel="noreferrer noopener"
                    target="_blank"
                    className="linkedin-link"
                    >LinkedIn</a> page.</p>
        </div>
    );
}


