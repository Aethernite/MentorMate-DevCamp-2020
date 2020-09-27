import React from 'react';
//Styled Components
import styled from 'styled-components';
//Post subcomponents
import PostHeader from './subcomponents/post/PostHeader.js';
import PostContent from './subcomponents/post/PostContent.js';
import PostBase from './subcomponents/post/PostBase.js';
//CSS Libraries
import '@fortawesome/fontawesome-free/css/all.min.css';
import 'bootstrap-css-only/css/bootstrap.min.css';
import 'mdbreact/dist/css/mdb.css';

const Section = styled.section`
padding: 1.25rem 0px !important;
padding-top: 0px;
padding-bottom: 0px;
margin: 0px !important;
`;

const Cardbox = styled.div`
border-radius: 3px;
margin-bottom: 20px;
padding: 0px !important;
`;

function Post({ post, key }) {
    return (
        <Section>
            <div className="container">
                <div className="row">
                    <div className="col-lg-6 offset-lg-3">
                        <Cardbox className="shadow-lg bg-white">
                            <PostHeader post={post} />
                            <PostContent post={post} />
                            <PostBase post={post} />
                        </Cardbox>
                    </div>
                </div>
            </div>
        </Section>
    );
}

export default Post;