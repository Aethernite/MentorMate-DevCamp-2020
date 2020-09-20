import React from 'react';
//CSS Libraries
import '@fortawesome/fontawesome-free/css/all.min.css';
import 'bootstrap-css-only/css/bootstrap.min.css';
import 'mdbreact/dist/css/mdb.css';
//Post component
import Post from './Post'

function NewsPage({ mockedPosts }) {

    return (
        <section style={{ paddingTop: '8rem' }}>
            {mockedPosts.map((post, index) => (
                <Post
                    key={index}
                    post={post}
                />
            ))}
        </section>
    );
}

export default NewsPage;