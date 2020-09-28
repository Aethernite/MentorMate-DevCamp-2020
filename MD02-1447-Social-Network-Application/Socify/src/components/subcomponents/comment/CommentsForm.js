import React from 'react';
import styled from 'styled-components';
import { useSelector, useDispatch } from 'react-redux';
import { placeholder, generateMediaUrl } from '../../../utilities';
import { Spinner } from 'react-bootstrap';
import { useFormik } from 'formik';
import TextareaAutosize from 'react-textarea-autosize';
import CommentFileUploadButton from './CommentFileUploadButton';
import { createComment } from '../../../store/slices/comments';
import { removeCommentMedia } from '../../../store/slices/upload';

const CloseButton = styled.button`
background: none;
color: #bbbbbb;
padding: 10px 10px;
cursor: pointer;
border: none;
outline:none;
transition: transform 0.2s;
position: absolute;
z-index: 1;
right: 20px;

 &:focus{
    outline:0;
 }

 &:hover{
    transform: scale(1.2);
 }
`;

const Icon = styled.i`
 font-size: 20px;
 display: inline-block;
`;

const Name = styled.span`
font-family: 'Roboto', sans-serif;
text-align: left;
font-size: 0.9rem;
display: block;
line-height: 1.5;
font-weight: 500;
`;

const Username = styled.span`
font-family: 'Roboto', sans-serif;
text-align: left;
font-size: 0.7rem;
display: block;
line-height: 1;
font-weight: 300;
`;

const Img = styled.img`
width: 50px !important;
height: 50px !important;
margin: 0px;
vertical-align: top;
`;


function CommentsForm({ post }) {


    const user = useSelector(state => state.auth.user);
    const isLoading = useSelector(state => state.upload.isLoading);
    const media = useSelector(state => state.upload[post.id]);
    const dispatch = useDispatch();

    const submitButton = React.useRef();
    const textArea = React.useRef();
    const formik = useFormik({
        initialValues: {
            postId: post.id,
            content: '',
            mediaId: null
        },

        onSubmit: (values) => {
            if (media) {
                values.mediaId = media.id;
            }
            dispatch(createComment(values));
            values.mediaId = null;
            values.content = '';
            dispatch(removeCommentMedia({ postId: post.id }));
        },

    });

    const handleKeyPress = event => {
        if (event.keyCode === 13) {
            event.preventDefault();
            if (textArea.current.value.length > 0 && !(/^\s+$/.test(textArea.current.value))) {
                submitButton.current.click();
                textArea.current.value = '';
                textArea.current.setSelectionRange(0, 0);
            }
        }
    };

    return (
        <>
            <div class="media-body text-left">
                <div style={{ display: 'block' }}>
                    <Img className="rounded-circle" src={user.avatarId ? generateMediaUrl(user.avatarId) : placeholder} alt="Avatar" />
                    <div style={{ display: 'inline-block' }}>
                        <Name>{user.name}</Name>
                        <Username>({user.username})</Username>
                    </div>
                </div>
            </div>
            <form id="create-comment-form" className="d-flex justify-content-center" onSubmit={formik.handleSubmit}>
                <CommentFileUploadButton postId={post.id} className="btn w-100" />
                <TextareaAutosize ref={textArea} name="content" className="form-control" style={{ border: 'none', resize: 'none', overflowY: 'hidden', marginBottom: '1rem', width: '85%', display: 'block' }} placeholder={`What's on your mind, ${user.name}`} onChange={formik.handleChange} onBlur={formik.handleBlur} onKeyDown={e => handleKeyPress(e)}></TextareaAutosize>
                <div className="d-flex justify-content-center" style={{ display: 'block' }}>
                    <Spinner hidden={!isLoading} animation="border" role="status">
                        <span className="sr-only">Loading...</span>
                    </Spinner>
                </div>
                <button ref={submitButton} type="submit" style={{ display: 'none' }}></button>
            </form>
            <div style={{ display: media?.id ? 'block' : 'none' }}>
                <div className="d-flex justify-content-center">
                    <img className="img-fluid" src={generateMediaUrl(media?.id)} alt="Post Content" style={{ width: '70%' }} />
                    <CloseButton type="button" onClick={() => dispatch(removeCommentMedia({ postId: post.id }))}><Icon className="fa fa-times"></Icon></CloseButton>
                </div>
            </div>
        </>
    );
}

export default CommentsForm;