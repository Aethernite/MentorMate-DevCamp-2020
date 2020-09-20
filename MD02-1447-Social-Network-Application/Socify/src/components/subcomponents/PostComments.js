import React from 'react';
import styled from 'styled-components';
import { useAuth } from '../../contexts/AuthContext';
import { Link } from "react-router-dom";

const CardBoxComments = styled.div`
text-align: center;
display: inline-block;
width: 85%;
padding: 2%;
`;

const Img = styled.img`
margin-top: 10px;
margin-right: 10px;
margin-left: 10px;
margin-bottom: -10px;
position: relative;
display: inline-block;
text-align: center;
width: 50px;
height: 50px;
`;

const CommentInput = styled.div`
 position: relative;
 right: -60px;
 top: -40px;
 margin-bottom: -40px;
 border: none;	
 width: 100%;
 overflow: hidden;
`;

const Input = styled.input`
 background-color: #fff;
 line-height: 10px;
 padding: 15px 60px 20px 10px;
 border: none;
 border-radius: 4px;
 font-family: 'Roboto', sans-serif;
 font-style: italic;
 font-size: 14px;
 color: #8d8d8d;
 height: inherit;
`;

const Form = styled.div`
margin-top: 0px;
margin-bottom: 0px;
`;

const Button = styled.button`
position: absolute;
top: 0px;
right:0px;
background-color: transparent;
color: #bbbbbb;
padding: 10px 10px;
cursor: pointer;
border: none;
outline:none;
display: flex;
justify-content: center;
align-items: center;
text-align: center;
 transition: transform 0.2s;

 &:focus{
    outline:0;
 }

 &:hover{
    transform: scale(1.2);
 }
`;

const Icon = styled.i`
 font-size: 20px;
 display: block;
`;

function PostComments() {

    const { mockedUser } = useAuth();
    return (
        <CardBoxComments>
            <span className="float-left">
                <Link to="/me"><Img className="rounded-circle" src={mockedUser.avatar} /></Link>
            </span>
            <CommentInput>
                <Form className="md-form" style={{ padding: '10px' }}>
                    <Input placeholder="Add a comment" type="text" className="form-control" />
                </Form>
                <Button><Icon className="fa fa-camera"></Icon></Button>
            </CommentInput>
        </CardBoxComments>
    );
}

export default PostComments;