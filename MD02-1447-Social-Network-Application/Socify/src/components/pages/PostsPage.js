import React from 'react';
//CSS Libraries
import '@fortawesome/fontawesome-free/css/all.min.css';
import 'bootstrap-css-only/css/bootstrap.min.css';
import 'mdbreact/dist/css/mdb.css';
//Post component
import Post from '../Post'
import PostForm from '../PostForm';

function PostsPage({ posts }) {
    return (
        <section style={{ paddingTop: '3rem' }}>
            <PostForm></PostForm>
            {posts.map((post, index) => (
                <Post
                    key={index}
                    post={post}
                />
            ))}
        </section>
    );
}

export default PostsPage;